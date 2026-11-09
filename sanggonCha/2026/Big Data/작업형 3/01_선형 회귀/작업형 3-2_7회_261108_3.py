# 선형 회귀

import pandas as pd
df = pd.read_csv('financial.csv')

# 문제2-1.다음의 financial.csv 파일 데이터를 가지고 각 변수 간 상관관계를 계산하고,
#         Sales와 가장 상관관계가 높은 변수와 그 값을 반올림하여 소수 셋째 자리까지 출력하세요.
df2 = df.corr().abs().drop('Sales').loc[:, 'Sales']
max_val = df2.max()
max_col = df2.idxmax()

# 문제2-2. Cost 컬럼이 2000 이하인 데이터만 찾아 
df3 = df.loc[df['Cost'] <= 2000, : ]

# Sales를 종속 변수로 나머지 변수들을 독립 변수로 설정하여 선형 회귀 모델을 만들고 결정계수를 구하세요.
# (반올림하여 소수 셋째자리까지 계산)
from statsmodels.formula.api import ols
model = ols('Sales ~  Cost +	Profit +	GrowthRate	+ EmployeeCount', data=df3).fit()
print(round(model.rsquared, 3))