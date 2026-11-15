# 데이터 생성

import pandas as pd
import numpy as np

# 데이터 생성
np.random.seed(2024)
n_samples = 1000

data = {
    'employee_id': range(1, n_samples + 1),
    'salary': np.random.randint(30000, 120000, n_samples),
    'years_of_experience': np.random.randint(1, 30, n_samples),
    'job_level': np.random.choice(['Junior', 'Mid', 'Senior'], n_samples)
}

# DataFrame 생성
df = pd.DataFrame(data)

# CSV 파일로 저장
df.to_csv('employee_salary_data.csv', index=False)


#답:
import pandas as pd

# CSV 파일에서 데이터 로드
df = pd.read_csv('employee_salary_data.csv')


# 1사분위수와 3사분위수 계산
# df_q1 = df['salary'].quantile(0.25)
# df_q3 = df['salary'].quantile(0.75)
q1 = df.salary.quantile(0.25)
q3 = df.salary.quantile(0.75)


# 3사분위수와 1사분위수의 차이 계산 (절대값)
# diff = abs(df_q3 - df_q1)
# diff = abs(df_q1 - df_q3)
# diff
diff = abs(a - b)
diff

# 소수점 버림 후 정수로 출력
result = int(diff)

# 결과 출력
print(result)