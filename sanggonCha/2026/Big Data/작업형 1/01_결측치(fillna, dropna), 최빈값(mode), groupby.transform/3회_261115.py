#답:

import pandas as pd

# 1.CSV 파일에서 데이터 로드
df = pd.read_csv('employee_data.csv')

#문제:

# 특정 회사의 직원 데이터셋에서 각 컬럼의 결측값 비율을 계산하여,
# 결측값 비율이 가장 높은 변수명을 출력하세요.

ans = df.isnull().sum().idxmax()
print(ans)