# 답:
#1. 데이터 로드
import  pandas  as  pd
df = pd.read_csv("customers.csv")


#2. 평균값와 표준편차*2 구하기
df
df_mean = df['purchase_amount'].mean()
df_mean
df_std2 = df['purchase_amount'].std() * 2
df_std2

#3. 이상치 구하기
outlier = df.loc[(df['purchase_amount'] > df_mean + df_std2) | (df['purchase_amount'] < df_mean - df_std2), 'purchase_amount']

#4. 이상치들의 합 계산하기
outlier_sum = outlier.sum()

#5. 결과 출력하기
print(outlier_sum)