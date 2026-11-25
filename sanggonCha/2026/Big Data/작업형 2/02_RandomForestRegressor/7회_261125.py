# 훈련 데이터를 사용하여 총 생산량을 예측하는 모델을 만드세요.
# 해당 모델을 테스트 데이터에 적용하여 예측값을 구한 후, 예측값을 result.csv 파일로 저장하세요.

# 데이터 로드
import pandas as pd
train_data = pd.read_csv("auto_train.csv")
test_data = pd.read_csv("auto_test.csv")

tr2 = train_data.drop(columns='part_id')
te2 = test_data.drop(columns='part_id')

x = tr2.iloc[:, :-1]
y = tr2.iloc[:, -1]

from sklearn.preprocessing import MinMaxScaler
scaler = MinMaxScaler()
scaler.fit(x)
x3 = scaler.transform(x)
te3 = scaler.transform(te2)

from sklearn.ensemble import RandomForestRegressor
model = RandomForestRegressor()
model.fit(x3, y)

pred = model.predict(te3)

pd.DataFrame({'part_id': test_data['part_id'], 'pred': pred}).to_csv('result.csv', index=False)