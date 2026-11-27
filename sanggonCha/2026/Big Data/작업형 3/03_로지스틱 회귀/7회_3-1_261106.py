# 로지스틱 회귀

import pandas as pd
import numpy as np
import statsmodels.api as sm

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
beta1 = result.params['판매수량'] # 독립변수의 회귀계수
print(round(np.exp(beta1), 4))