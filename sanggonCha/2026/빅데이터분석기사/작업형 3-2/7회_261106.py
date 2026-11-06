from statsmodels.formula.api import ols
import pandas as pd
-- 2-1
# 답:
# 데이터 불러오기
df = pd.read_csv('financial.csv')
df2 = df.corr()
df3 = df2.drop('Sales')
df4 = df3['Sales']
max_col = df4.idxmax()
max_val = round(df4.max(), 3)
print(max_col, max_val)

-- 2-2

# 데이터 불러오기
df = pd.read_csv('financial.csv')
df

# Cost 컬럼이 2000 이하인 데이터
df2 = df.loc[df['Cost'] <= 2000, :]
df2

# Sales를 종속 변수로, 나머지 변수들을 독립 변수로 설정하여 선형 회귀 모델 생성
model = ols('Sales ~ Cost + Profit + GrowthRate + EmployeeCount', data=df2)
data = model.fit()

# 결정계수를 구하세요.반올림하여 소수 셋째자리까지 계산)
print(round(data.rsquared, 3))

-- 2-3
data.summary()
max_name = data.pvalues.idxmax()
max_value = round(data.pvalues.max(), 2)
print(max_name, max_value)