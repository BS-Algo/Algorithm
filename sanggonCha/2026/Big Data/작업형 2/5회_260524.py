import pandas as pd

# 1. 데이터 로드
X_test = pd.read_csv("X_test.csv")
X_train = pd.read_csv("X_train.csv")
y_train = pd.read_csv("y_train.csv")
X_train

# device_id: 기기의 고유 식별자 (분석 제외).
# year: 제조 연도 (2010~2021).
# usage_hours: 누적 사용 시간.
# warranty: 보증 기간 (1~5년).
# battery_life: 배터리 수명 (%).
# storage_capacity: 저장 용량 (GB).

#2. device_id 컬럼 제거
x_train2 = X_train.drop(columns='device_id')
x_test2 = X_test.drop(columns='device_id')

#3. 데이터 정규화
from sklearn.preprocessing import MinMaxScaler

scaler = MinMaxScaler()
scaler.fit(x_train2)
x_train3 = scaler.transform(x_train2) # 훈련 데이터 스케일링
x_test3 = scaler.transform(x_test2) # 훈련 데이터 스케일

#4. 모델 생성
# 회귀 모델은 RandomForestRegressor
from sklearn.ensemble import RandomForestRegressor

model = RandomForestRegressor()

#5. 모델 훈련
model.fit(x_train3, y_train) # 훈련 데이터, 정답 데이터

#6. 테스트 데이터 예측
pred = model.predict(x_test3)

#7. 테스트 데이터의 예측값 제출

pd.DataFrame( {'device_id' : X_test['device_id'], 'label' : pred }).to_csv('003000.csv', index=False)

#8. 훈련데이터의 예측값과 훈련 데이터의 정답과의 상관계수
# import numpy as  np
import numpy as np

y_pred = model.predict(x_train3)

print( np.corrcoef(y_pred, y_train.values.flatten())  )
