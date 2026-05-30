# 문제. 호텔 예약 관리 시스템

# 호텔 예약 관리 시스템에서 고객에게 부과된 총 청구 금액을 예측하세요.

# 제공된 데이터 목록:

# hotel_train.csv (훈련 데이터)
# hotel_test.csv (평가용 데이터)
# 예측할 컬럼: TotalBill (총 청구액)

# 학습용 데이터(hotel_train.csv)를 이용하여 총 청구액을 예측하는 모델을 만든 후,
# 이를 평가용 데이터(hotel_test.csv)에 적용해 예측값을 다음과 같은 형식의 CSV 파일로 생성하세요.

# 제출 파일은 다음 1개의 컬럼을 포함해야 합니다.
# pred: 예측된 총 청구액
# 제출 파일명: result.csv

# # 제출한 모델의 성능은 MAE(Mean Absolute Error) 평가 지표에 따라 채점합니다.
# 답:
# 훈련 및 테스트 데이터 생성
n_train = 1000  # 훈련 데이터 샘플 수
n_test = 200    # 테스트 데이터 샘플 수

hotel_train = generate_hotel_data(n_train)
hotel_test = generate_hotel_data(n_test).drop(columns=['TotalBill'])  # 테스트 데이터에서는 총 청구액 제외

# 데이터 확인
hotel_train.head(3)

# 1. 독립변수와 종속변수 분리
x = hotel_train.iloc[ : , : -1]
y = hotel_train.iloc[ : , -1]

# 2. 모델 생성
from sklearn.ensemble import RandomForestRegressor

model = RandomForestRegressor()

# 2. 모델 학습
model.fit(x, y)

# 3. 모델 예측
pred =  model.predict(hotel_test)

# 4. 정답 제출
import pandas as pd
submission = pd.DataFrame( { 'pred' : pred } )
submission.to_csv('result.csv', index=False)

# 5. MAE로 교차 검증
from sklearn.metrics import mean_absolute_error

y_train_pred = model.predict(x)
mean_absolute_error(y_train_pred, y) # 0.20939097253142233: 오차의 값이 작을 수록 좋은 결과