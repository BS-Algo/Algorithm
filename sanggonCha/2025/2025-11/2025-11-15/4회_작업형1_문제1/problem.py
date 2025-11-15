#답:
import pandas as pd

# CSV 파일에서 데이터 로드
df = pd.read_csv('employee_salary_data.csv')

# 1사분위수와 3사분위수 계산  
q1 = df.salary.quantile(0.25) 
q3 = df.salary.quantile(0.75)
q1
q3

# 3사분위수와 1사분위수의 차이 계산 (절대값)
diff = abs(q1 - q3)

# 소수점 버림 후 정수로 출력
result = int(diff)

# 결과 출력
print(result)