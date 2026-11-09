# 로지스틱 회귀

# 문제:

# '판매수량'을 독립변수로, '회원등급'을 종속변수로 사용하여 로지스틱 회귀 모형을 만드세요.
#  이때, '판매수량' 변수가 한 단위 증가할 때
# '회원등급'에 미치는 영향의 오즈비 값은 무엇입니까? (반올림하여 소수 넷째자리까지 계산)

# 데이터 로드
train = pd.read_csv("sales_train.csv")
x = train['판매수량']
y = train['회원등급']

import statsmodels.api as sm
X = sm.add_constant(x)
model = sm.Logit(y, X).fit()
beta = model.params['판매수량'] # 회귀계수

import numpy as np
odds = np.exp(beta) # 회귀계수를 지수화하면 오즈비
print(round(odds, 4))