#답:

import pandas as pd

# 1.CSV 파일에서 데이터 로드
df = pd.read_csv('employee_data.csv')
# df

# 2.전체 데이터 행수
len(df) # 200

# 3.각 컬럼의 결측값 비율 계산
# df.isnull().sum()
# Employee_ID	0
# Age	80
# Job_Level	100
# Salary	176
# Department	45

# df.isnull().sum() / len(df)
# Employee_ID	0.000
# Age	0.080
# Job_Level	0.100
# Salary	0.176
# Department	0.045

nan_ratio = df.isnull().sum() / len(df)
# nan_ratio

# 4. 결측값 비율이 가장 높은 컬럼명 출력
max_column = nan_ratio.idxmax() # idxmax: index of maximum
print(max_column)