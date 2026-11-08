# 선형 회귀

# 문제2-1.다음의 financial.csv 파일 데이터를 가지고 각 변수 간 상관관계를 계산하고,
#         Sales와 가장 상관관계가 높은 변수와 그 값을 반올림하여 소수 셋째 자리까지 출력하세요.
#답:
# 데이터 불러오기
import pandas as pd
df = pd.read_csv('financial.csv')

df2 = df.corr()['Sales'].drop('Sales').abs()
max_val = round(df2.max(), 3)
max_col = df2.idxmax()
print(max_val, max_col)

# 문제2-2. Cost 컬럼이 2000 이하인 데이터만 찾아 Sales를 종속 변수로,
# 나머지 변수들을 독립 변수로 설정하여 선형 회귀 모델을 만들고 결정계수를 구하세요.
# (반올림하여 소수 셋째자리까지 계산)
# 데이터 불러오기
df = pd.read_csv('financial.csv')

df3 = df.loc[df['Cost'] <= 2000, : ]

from statsmodels.formula.api import ols
model = ols('Sales ~ Cost + Profit + GrowthRate + EmployeeCount', data=df3)
model_data = model.fit()
result = round(model_data.rsquared, 3)
print(result)

# 문제2-3. 문제2-2 에서 만든 모델의 독립변수중 p-value 가 가장 큰 독립변수명과 p-value를 출력하세요
#          p-value 값은 반올림하여 소수점 둘째자리까지만 출력해서 제출하세요.
pvalues = model_data.pvalues
max_col = pvalues.idxmax()
max_val = round(pvalues.max(), 2)
print(max_col, max_val)