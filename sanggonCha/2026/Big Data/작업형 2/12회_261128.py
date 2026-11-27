import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestRegressor
from sklearn.metrics import mean_squared_log_error

# 0. 데이터 불러오기
train = pd.read_csv("store_train.csv")
test = pd.read_csv("store_test.csv")
train.head(10)

# 편의점 판매수량 예측 모델 개발
# 편의점 본사는 매일 각 점포의 상품별 판매수량을 예측 해 자동 발주량을 정한다.
# 학습 데이터(store_train.csv)를 이용하여 판매수량(qty)을 예측하는 모델을 만들고, 평가 데이터(store_test.csv)의 예측 결과를 제출하시오.

train2 = train.drop(columns='id')
test2 = test.drop(columns='id')

x = train2.iloc[:, :-1]
y = train2.iloc[:, -1]

import pandas as pd

x3 = pd.get_dummies(x)
test3 = pd.get_dummies(test2)

from sklearn.ensemble import RandomForestRegressor
model = RandomForestRegressor(random_state=42)
model.fit(x3, y)
pred = model.predict(test3)
pd.DataFrame({'id': test['id'], 'pred': pred}).to_csv('수험번호.csv', index=False)