from ast import mod
# 답:

# 1.독립변수와 종속변수 분리
x = hotel_train.iloc[:, :-1]
y = hotel_train['TotalBill']

# 2.모델 학습
from sklearn.ensemble import RandomForestRegressor

model = RandomForestRegressor()
model.fit(x, y)

# 3.예측 수행
pred = model.predict(hotel_test)

# 4.결과 저장
import pandas as pd

result = pd.DataFrame({'pred': pred})
result.to_csv('result.csv', index=False)

# 5.MAE 계산 (훈련 데이터로 교차 검증)
from sklearn.metrics import mean_absolute_error

y_pred = model.predict(x)
mean_absolute_error(y, y_pred)
