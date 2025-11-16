# 수치 예츠 모델(다중 회귀 모델 or 랜덤 포레스트 회귀 모델)
import pandas as pd

# 1. 데이터 로드
X_test = pd.read_csv("X_test.csv") # 시험 데이터(학습된 모델이 예측할, 정답 없음)
X_train = pd.read_csv("X_train.csv") # 학습 데이터(모델 훈련용)
y_train = pd.read_csv("y_train.csv") # 정답 데이터(학습 데이터에 대한)
# X_train
y_train

# device_id: 기기의 고유 식별자 (분석 제외).
# year: 제조 연도 (2010~2021).
# usage_hours: 누적 사용 시간.
# warranty: 보증 기간 (1~5년).
# battery_life: 배터리 수명 (%).
# storage_capacity: 저장 용량 (GB).

#2. device_id 컬럼 제거
x_train2 = X_train.drop(columns='device_id')
# x_train2
x_test2 = X_test.drop(columns='device_id')
# x_test2

#3. 데이터 정규화
from sklearn.preprocessing import MinMaxScaler

scaler = MinMaxScaler()
scaler.fit(x_train2) # 최댓값, 최솟값을 기억하는 과정
x_train_scaled = scaler.transform(x_train2) # 최댓값: 1, 최솟값: 0 을 사용하여 비율에 맞게 정규화
# x_train_scalerd
x_test_scaled = scaler.transform(x_test2) # 최댓값: 1, 최솟값: 0 을 사용하여 비율에 맞게 정규화

#4. 모델 생성
from sklearn.ensemble import RandomForestRegressor

model = RandomForestRegressor()

#5. 모델 훈련
model.fit(x_train_scaled, y_train)

#6. 테스트 데이터 예측
pred = model.predict(x_test_scaled)
pred
#7. 테스트 데이터의 예측값 제출

pd.DataFrame( {'device_id' : X_test['device_id'], 'label' : pred }).to_csv('003000.csv', index=False)

#8. 훈련데이터의 예측값과 훈련 데이터의 정답과의 상관계수
# import numpy as np

# y_pred_train = model.predict(x_train_scaled)
# # y_pred_train

# print(np.corrcoef(y_pred_train, y_train.values.flatten()))
