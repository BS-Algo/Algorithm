# 다중 선형 회귀

# 문제2-1.

# 주어진 데이터를 이용해 종속변수(Score)와 독립변수(StudyHours, Attendance, Participation)로
# 다중 선형 회귀 분석을 수행하세요.
# 이때 유의확률(p-value)이 가장 작은 변수의 회귀 계수 값을 구하세요.
# (반올림하여 소수 셋째 자리까지 계산)
from statsmodels.formula.api import ols
model = ols('Score ~ StudyHours + Attendance + Participation', data=df)
result = model.fit()
ans = round(result.params[result.pvalues.idxmin()], 3)
# print(ans)

x = df[['StudyHours', 'Attendance', 'Participation']]
y = df['Score']


import statsmodels.api as sm
X = sm.add_constant(x)
result = sm.OLS(y, X).fit()
ans1 = round(result.params[result.pvalues.idxmin()], 3)
print(ans1)
# 문제2-2.

# 문제2-1에 적합한 모델의 결정 계수(R-squared) 값을 구하세요. (반올림하여 소수 둘째 자리까지 계산)
ans2 = round(result.rsquared, 2)
print(ans2)