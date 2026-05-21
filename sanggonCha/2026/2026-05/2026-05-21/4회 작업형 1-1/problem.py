#답:
import pandas as pd

# CSV 파일에서 데이터 로드
df = pd.read_csv('employee_salary_data.csv')

# #문제:
# employee_salary_data.csv 데이터의 

# salary 컬럼의 3사분위수와 1사분위수의 차이를 절대값으로 구하고,
q1 = df['salary'].quantile(0.25)
q3 = df['salary'].quantile(0.75)
diff = abs(q1-q3)

# 소수점 버림 후 정수로 출력하세요.
print(round(diff))
