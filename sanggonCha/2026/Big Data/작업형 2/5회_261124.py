# 문제:

# 가상의 전자기기 수리 데이터셋을 기반으로,특정 전자기기의 예상 수리 비용을 예측하는 모델을 만드세요.
# 주어진 특징(제조연도, 사용시간, 보증기간, 배터리 수명, 저장 용량)을 사용하여 수리 비용을 예측합니다.

# 데이터 설명:

# device_id: 기기의 고유 식별자 (분석 제외).
# year: 제조 연도 (2010~2021).
# usage_hours: 누적 사용 시간.
# warranty: 보증 기간 (1~5년).
# battery_life: 배터리 수명 (%).
# storage_capacity: 저장 용량 (GB).

# 1. 데이터 로드
X_test = pd.read_csv("X_test.csv")
X_train = pd.read_csv("X_train.csv")
y_train = pd.read_csv("y_train.csv")

x_train2 = X_train.drop(columns='device_id')
x_test2 = X_test.drop(columns='device_id')

from sklearn.preprocessing import MinMaxScaler
scaler = MinMaxScaler()
scaler.fit(x_train2)
x_train3 = scaler.transform(x_train2)
x_test3 = scaler.transform(x_test2)

from sklearn.ensemble import RandomForestRegressor
model = RandomForestRegressor()
model.fit(x_train3, y_train)

pred = model.predict(x_test3)

pd.DataFrame({'device_id': X_test['device_id'], 'label': pred}).to_csv('수험번호.csv', index=False)