# 문제:

# '판매수량'을 독립변수로, '회원등급'을 종속변수로 사용하여 로지스틱 회귀 모형을 만드세요.
#  이때, '판매수량' 변수가 한 단위 증가할 때
# '회원등급'에 미치는 영향의 오즈비 값은 무엇입니까? (반올림하여 소수 넷째자리까지 계산)

#답:
import pandas as pd
import numpy as np
import statsmodels.api as sm # 로지스틱 회귀

# 데이터 로드
train = pd.read_csv("sales_train.csv")

# 독립변수와 종속변수 구분
x = train.loc[ : , '판매수량']
y = train.loc[ : , '회원등급']

# 독립변수에 상수항을 추가
X = sm.add_constant(x)

# 로지스틱 회귀 모델 생성하고 학습
model = sm.Logit(y, X)
result = model.fit()

# 오즈비 계산
beta1 = result.params['판매수량']
result = round(np.exp(beta1), 4)
print(result)