
# 답:
#1. 데이터 로드
import  pandas  as  pd
df = pd.read_csv("customers.csv")

#2. 평균값와 표준편차*2 구하기
pa_mean = df['purchase_amount'].mean()
pa_std = df['purchase_amount'].std(ddof=1)

upper_bound = pa_mean + 2 * pa_std
lower_bound = pa_mean - 2 * pa_std

#3. 이상치 구하기
outliers = df.loc[ (df['purchase_amount'] > upper_bound) | (df['purchase_amount'] < lower_bound), 'purchase_amount']

#4. 이상치들의 합 계산하기
outliers_sum = outliers.sum()

#5. 결과 출력하기
ans = outliers_sum
print(ans)
