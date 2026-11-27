# 1. 라이브러리 임포트
import pandas as pd


# 2. 데이터 로드
X_train = pd.read_csv('X_train.csv')
y_train = pd.read_csv('y_train.csv')
X_test = pd.read_csv('X_test.csv')
X_train.head()

# 여러분은 에너지 관리 회사의 데이터 분석가입니다. 다양한 시설의 월별 가스 사용량을 예측하여 효율적인 에너지 관리와 비용 절감을 돕는 것이 목표입니다.
x_test2 = X_test.drop(columns='id')
x_train2 = X_train.drop(columns='id')

x_total = pd.concat([x_train2, x_test2])
x_total2 = pd.get_dummies(x_total)

x_train3 = x_total2.iloc[:len(x_train2), :]
x_test3 = x_total2.iloc[len(x_train2):, :]

from sklearn.ensemble import RandomForestRegressor
model = RandomForestRegressor()
model.fit(x_train3, y_train.iloc[:,-1])

pred = model.predict(x_test3)

pd.DataFrame({'id': X_test['id'], 'pred': pred}).to_csv('result.csv', index=False)