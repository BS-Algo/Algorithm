# 선형 회귀
# 문제:
# 회사의 ERP 시스템 사용을 최적화하기 위해 CPU 사용량과 다양한 시스템 성능 변수들을 분석하고자 합니다.
# 주어진 데이터에서 CPU 사용량이 100 미만인 데이터를 추출하고
df2 = df.loc[df['CPU'] < 100, : ]

# ERP 사용량을 종속 변수로 다른 성능 변수들을 독립 변수로 설정하여 선형 회귀 모델을 만들어 회귀 계수를 구하세요.
from statsmodels.formula.api import ols
model = ols('ERP ~ Feature1 +	Feature2 +	Feature3 +	CPU', data=df2).fit()

# 또한, 만든 모델에서 독립 변수 중 p-value가 가장 높은 값을 구하세요.
# (소수 셋째자리까지 반올림하여 계산)
result = round(model.pvalues.max(), 3)
print(result)

# 문제2-3. 문제2-2 에서 만든 모델의 독립변수중 p-value 가 가장 큰 독립변수명과 p-value를 출력하세요
# p-value 값은 반올림하여 소수점 둘째자리까지만 출력해서 제출하세요.
max_val = round(model.pvalues.max(), 2)
max_col = model.pvalues.idxmax()
print(max_val, max_col)