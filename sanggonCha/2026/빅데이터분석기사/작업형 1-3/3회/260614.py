#답:

import pandas as pd

# 1.CSV 파일에서 데이터 로드
df = pd.read_csv('employee_data.csv')

# 2.전체 데이터 행수
total_len = len(df)

# 3.각 컬럼의 결측값 비율 계산
df_missing = df.isnull().sum().sort_values().index

# or 

max_idx = df.isnull().sum().idxmax()

# 4. 결측값 비율이 가장 높은 컬럼명 출력
ans1 = df_missing[-1]
ans2 = max_idx
print(ans1)
print(ans2)