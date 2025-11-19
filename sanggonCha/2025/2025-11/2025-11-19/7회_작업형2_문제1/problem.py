#답:
# 데이터 로드
import pandas as pd
train_data = pd.read_csv("auto_train.csv")
test_data = pd.read_csv("auto_test.csv")
train_data

# 독립변수와 종속변수 분리
x = train_data.iloc[:, 1:-1] # material_quality	processing_time	worker_experience	machine_efficiency	temperature
y = train_data['total_production'] # total_production

# 모델 생성
from sklearn.ensemble import RandomForestRegressor
model = RandomForestRegressor()

# 모델 훈련
model.fit(x, y)

# 예측 수행
pred = model.predict(test_data.iloc[ : , 1: ])
pred

# 결과 저장
import pandas as pd
submission = pd.DataFrame( { 'pred': pred} )

submission.to_csv('result.csv', index=False) 