
# 답:
#1. 데이터 로드
import  pandas  as  pd
df = pd.read_csv("customers.csv")


#2. 평균값와 표준편차*2 구하기
df_mean = df['purchase_amount'].mean()
df_std = df['purchase_amount'].std(ddof=1) # 자유도 1이 default
df_upperBound = df_mean + df_std * 2
df_lowerBound = df_mean - df_std * 2

#3. 이상치 구하기
df_outlier = df.loc[(df['purchase_amount'] > df_upperBound) | (df['purchase_amount'] < df_lowerBound), : ]

#4. 이상치들의 합 계산하기
ans = df_outlier['purchase_amount'].sum()

#5. 결과 출력하기
print(ans)