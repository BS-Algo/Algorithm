import pandas as pd

df = pd.read_csv("data/employee_performance.csv")

# 사용자 코딩

# 해당 화면에서는 제출하지 않으며, 문제 풀이 후 답안제출에서 결괏값 제출

# 1
고객만족도_평균 = df['고객만족도'].mean()
df['고객만족도'] = df['고객만족도'].fillna(고객만족도_평균)

# 2
df = df.dropna(subset=['근속연수'])

# 3
import math

q3 = math.floor(df['고객만족도'].quantile(0.75))
print('q3' + q3)

# 4
mean_income = math.floor(df.groupby('부서')['연봉'].mean().sort_values()[-2])
print('mean_income'+ mean_income)
