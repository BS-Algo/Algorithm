# 답:

hotel_train
hotel_test # 이 데이터에서 TotalBill 컬럼값을 예측(숫자 예측이므로 RandomForestRegressor로 회귀모델을 사용)
# 1.독립변수와 종속변수 분리
x = hotel_train.iloc[ : , : -1] # 독립변수: TotalBill을 제외
y = hotel_train.iloc[ : , -1] # 종속변수: TotalBill

# 2.모델 학습
from sklearn.ensemble import RandomForestRegressor

model = RandomForestRegressor()
# 특별한 말이 없으면, 정규화(transform)를 수행하지 않음
model.fit(x, y) # 이게 모델 훈련

# 3.예측 수행
pred = model.predict(hotel_test)
pred # 예측된 TotalBill 값들

# 4.결과 저장
import pandas as pd

submission = pd.DataFrame({ 'pred': pred})
submission.to_csv('sanggon.csv')

######## 정답은 위에까지가 끝 ########

# 5.MAE 계산 (훈련 데이터로 교차 검증)
from sklearn.metrics import mean_absolute_error

train_pred = model.predict(x)
mean_absolute_error(train_pred, y) # 예측한 데이터, 정답 데이터
