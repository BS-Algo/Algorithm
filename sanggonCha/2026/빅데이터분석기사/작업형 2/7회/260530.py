# 문제:

# 자동차 부품 제조 회사는 부품 생산량을 예측하기 위해 다양한 데이터를 수집했습니다.
# 주어진 데이터는 각 부품의 특성과 생산 공정 데이터를 포함하고 있으며,
# 이를 바탕으로 부품의 총 생산량을 예측하는 모델을 개발하고자 합니다.

# # 제공된 데이터:

# 훈련 데이터: auto_train.csv (부품 특성과 총 생산량이 포함된 데이터)
# 테스트 데이터: auto_test.csv (부품 특성 데이터만 제공됨)

# # 예측할 컬럼:

# total_production (총 생산량)

# # 모델 개발 및 예측:

# 훈련 데이터를 사용하여 총 생산량을 예측하는 모델을 만드세요.
# 해당 모델을 테스트 데이터에 적용하여 예측값을 구한 후, 예측값을 result.csv 파일로 저장하세요.

# # 제출 파일 형식:

# 제출 파일은 result.csv로, 하나의 컬럼을 포함해야 합니다.
# pred 컬럼에 예측된 총 생산량을 저장하세요.

# # 성능 평가:

# 제출한 모델의 성능은 RMSE (Root Mean Square Error)로 평가됩니다.

# ------------------------------------------------------------------------

# 답:
# 데이터 로드
from sklearn.ensemble import RandomForestRegressor
import pandas as pd
train_data = pd.read_csv("auto_train.csv")
test_data = pd.read_csv("auto_test.csv")

# 1. 결측치가 있는지 확인
train_data.info()
train_data.isnull().sum()  # 0

# 2. 독립변수와 종속변수 분리
x = train_data.iloc[:, 1:-1]
y = train_data.iloc[:, -1]

# 3. 모델 생성

model = RandomForestRegressor()

# 4. 모델 훈련
model.fit(x, y)

# 5. 모델 예측
pred = model.predict(test_data.iloc[:, 1:])
pred

# 6. 정답 제출
submission = pd.DataFrame({'pred': pred})
submission.to_csv('result.csv', index=False)
