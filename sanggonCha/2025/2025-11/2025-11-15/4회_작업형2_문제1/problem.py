# 분류 모델
 # 1. 기계 학습 시킬 데이터를 불러옵니다.
import pandas as pd
X_train = pd.read_csv('train.csv') # 훈련 데이터
y_train = pd.read_csv('y_train.csv') # 정답 데이터
X_test = pd.read_csv('test.csv') # 테스트 데이터
# X_train.shape # (1000, 5)
# y_train.shape # (1000, 1)
# X_test.shape # (300, 5)

# 2. 데이터를 정규화 합니다.
from sklearn.preprocessing import MinMaxScaler

scaler = MinMaxScaler()
scaler.fit(X_train) # 최대값과 최소값을 기억하는 과정
x_train2 = scaler.transform(X_train) # 기억한 최대값과 최소값으로 정규화 진행
x_test2 = scaler.transform(X_test) # 기억한 최대값과 최소값으로 정규화 진행(테스트 데이터는 fit을 하지 않는다!)
# x_test2

# 3. 모델 생성
from sklearn.ensemble import RandomForestClassifier

model = RandomForestClassifier()

# 4. 모델 훈련
model.fit(x_train2, y_train)

# 5. 모델 예측
pred = model.predict(x_test2)
# pred

# 6. 정답 제출
pd.DataFrame( {'ID' : X_test.ID, 'label' : pred }).to_csv('003000.csv', index=False)

#7. 모델 평가
from sklearn.metrics import accuracy_score

y_hat = model.predict(x_train2)
accuracy_score(y_hat, y_train)