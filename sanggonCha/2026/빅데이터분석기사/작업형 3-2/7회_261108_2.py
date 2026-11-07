# 선형 회귀

#답:
# 데이터 불러오기
import pandas as pd
df = pd.read_csv('financial.csv')

# 문제2-1.다음의 financial.csv 파일 데이터를 가지고 각 변수 간 상관관계를 계산하고,
# Sales와 가장 상관관계가 높은 변수와 그 값을 반올림하여 소수 셋째 자리까지 출력하세요.
df2 = df.corr()
df3 = df2.drop('Sales')
df4 = df3.loc[:, 'Sales']
df5 = df4.abs()
max_val = round(df5.max(), 3)
max_col = df5.idxmax()
print(max_val, max_col)


import pandas as pd

# 데이터 불러오기
df = pd.read_csv('financial.csv')
df

# 문제2-2. Cost 컬럼이 2000 이하인 데이터만 찾아 Sales를 종속 변수로,
# 나머지 변수들을 독립 변수로 설정하여 선형 회귀 모델을 만들고 결정계수를 구하세요.
# (반올림하여 소수 셋째자리까지 계산)
df2 = df.loc[df['Cost'] <= 2000, : ]
from statsmodels.formula.api import ols
model = ols('Sales ~	Cost +	Profit +	GrowthRate +	EmployeeCount', data=df2).fit()
print(round(model.rsquared, 3))