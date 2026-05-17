import pandas as pd

#답:
# ■ 시험문제 풀기 시작

# ▣ 빅데이터 분석 기사 실기 유형2번 코드 암기하기(분류 파트)

# 1. 기계 학습 시킬 데이터를 불러옵니다.
X_test = pd.read_csv("X_test.csv") # 테스트 데이터
X_train = pd.read_csv("X_train.csv") # 학습 데이터 - 1: 구매 O, 0: 구매 X -> 구매 여부를 판단하는 분류 모델
y_train = pd.read_csv("y_train.csv") # 정답 데이터
# X_train
# y_train

# 2. 데이터를 정규화 합니다.
from sklearn.preprocessing import MinMaxScaler

# scaler 생성
scaler = MinMaxScaler()

# 학습 데이터 변환
scaler.fit(X_train.drop(columns=['cust_id'])) # 정규화: 0~1 사이의 데이터로 변환 / cust_id 는 의미없는 값
x_train2 = scaler.transform(X_train.drop(columns=['cust_id']))
x_train2

# 테스트 데이터 변환
x_test2 = scaler.transform(X_test.drop(columns=['cust_id']))
x_test2

# 3. 모델 생성
# 분류모델은 앙상블의 랜덤 포레스트
from sklearn.ensemble import RandomForestClassifier

model = RandomForestClassifier()

# 4. 모델 훈련
model.fit(x_train2, y_train) # 훈련 데이터, 정답 데이터(정규화시킨 데이터)

# 5. 모델 예측: 테스트 데이터를 예측
pred = model.predict(x_test2) # 마찬가지로 정규화시킨 데이터
pred

# 6. 정답 제출
# 답안 제출 참고
pd.DataFrame({'cust_id': X_test.cust_id, 'label': pred }).to_csv('003000000.csv', index=False)

#7. 모델 평가
from sklearn.metrics import accuracy_score

y_hat = model.predict(x_train2)

accuracy_score(y_hat, y_train) # 1.0: 정확도 100%