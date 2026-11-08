# 로지스틱 회귀

# 문제: 직원 이직 분석
# 주어진 데이터에서 로지스틱 회귀 분석을 수행해 유의확률(p-value)이 0.05 이상인
# 유의하지 않은 독립변수의 개수를 구하세요. (종속변수: Resign)


# 답:
import pandas as pd
df = pd.DataFrame(data)

# 독립변수와 종속변수 분리
x = df.iloc[ : , :-1]
y = df['Resign']

# 로지스틱 회귀분석을 위한 상수 추가
import statsmodels.api as sm
X = sm.add_constant(x)
X

# 로지스틱 회귀 모델 적합
model = sm.Logit(y, X)
result = model.fit()

# p-value가 0.05 이상인 독립변수의 개수 구하기
ans = (result.pvalues >= 0.05).sum()

# 결과 출력
print(ans)