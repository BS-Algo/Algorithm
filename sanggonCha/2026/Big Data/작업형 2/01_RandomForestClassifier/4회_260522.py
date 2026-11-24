#답:

# ▣ 시험환경 만들기 2. 데이터 로드 및 전처리

# 1. 기계 학습 시킬 데이터를 불러옵니다.
import pandas as pd
X_train = pd.read_csv('train.csv')
y_train = pd.read_csv('y_train.csv')
X_test = pd.read_csv('test.csv')

# 문제:

# 한 자동차 회사는 새로운 마케팅 전략을 수립하기 위해 고객을 4개의 세분화된 시장으로 나누었습니다.
# 기존 고객 데이터를 바탕으로 신규 고객이 어떤 세분화된 시장(Segmentation: 1, 2, 3, 4)에 속할지
# 예측하는 모델을 구축하세요.

# 1. 기계 학습 시킬 데이터를 불러옵니다.
X_train = pd.read_csv('train.csv')
y_train = pd.read_csv('y_train.csv')
X_test = pd.read_csv('test.csv')


# 2. 데이터를 정규화 합니다.
from sklearn.preprocessing import MinMaxScaler

scaler = MinMaxScaler()
scaler.fit(X_train)
x_train2 = scaler.transform(X_train)
x_test2 = scaler.transform(X_test)
x_test2

# 3. 모델 생성
from sklearn.ensemble import RandomForestClassifier

model = RandomForestClassifier()

# 4. 모델 훈련
model.fit(x_train2, y_train) # 훈련 데이터, 정답 데이터

# 5. 모델 예측
pred = model.predict(x_test2)

# 6. 정답 제출
pd.DataFrame( {'ID' : X_test.ID, 'label' : pred }).to_csv('252090.csv', index=False)

#7. 모델 평가
from sklearn.metrics import accuracy_score

y_hat = model.predict(x_train2)
accuracy_score(y_hat, y_train) # 1.0
