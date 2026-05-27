#답:

import pandas as pd

# 1.CSV 파일에서 데이터 로드
df = pd.read_csv('employee_data.csv')

# 2.전체 데이터 행수
df

# 3.각 컬럼의 결측값 비율 계산
a = (df.isnull().sum() / len(df))
b = a.idxmax()

# 4. 결측값 비율이 가장 높은 컬럼명 출력
print(b)