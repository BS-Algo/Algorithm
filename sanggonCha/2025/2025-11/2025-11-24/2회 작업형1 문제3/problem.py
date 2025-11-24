# 답:
#1. 데이터 로드
import  pandas  as  pd
df = pd.read_csv("customers.csv")

#2. 평균값와 표준편차*2 구하기
df_mean = df['purchase_amount'].mean()
df_std = df['purchase_amount'].std() * 2

#3. 이상치 구하기
upper_bound = df_mean + df_std
lower_bound = df_mean - df_std

df_outlier = df.loc[(df['purchase_amount'] > upper_bound) | (df['purchase_amount'] < lower_bound), 'purchase_amount']

#4. 이상치들의 합 계산하기
df_outlier_sum = df_outlier.sum()
df_outlier_sum

#5. 결과 출력하기
print(df_outlier_sum)