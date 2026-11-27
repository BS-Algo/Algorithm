# 로지스틱 회귀

# 문제:로지스틱 회귀 분석 문제
# 문제 설명
# 온라인 쇼핑몰에서 고객의 구매 패턴을 분석하여 회원등급을 예측하려고 합니다.

# 데이터 구성:

# 독립변수: 판매수량 (고객이 구매한 상품의 총 개수)
# 종속변수: 회원등급 (0: 일반회원, 1: VIP회원)

# 분석 과제:

# 판매수량을 독립변수로, 회원등급을 종속변수로 사용하여 로지스틱 회귀 모형을 구축하세요.
# 이때 판매수량이 1개 증가할 때 회원등급에 미치는 영향의 오즈비(Odds Ratio)를 계산하여
# 소수점 넷째자리까지 반올림한 값을 구하시오.

#답:

# 데이터 로드
train = pd.read_csv("sales_train.csv")

x = train['판매수량']
y = train['회원등급']

import statsmodels.api as sm
X = sm.add_constant(x)

model = sm.Logit(y, X).fit()

beta = model.params['판매수량']

import numpy as np
result = round(np.exp(beta), 4)
print(result)