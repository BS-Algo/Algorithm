#문제: 구매 예측 모델 생성 및 평가

# 문제 설명: 고객의 구매 이력을 바탕으로 특정 조건을 만족할 때 고객이 상품을 구매할지 예측하는
# 분류 모델을 생성하고 테스트 데이터의 예측결과를 제출하세요

#답:
# ■ 시험문제 풀기 시작

# ▣ 빅데이터 분석 기사 실기 유형2번 코드 암기하기(분류 파트)

# 1. 기계 학습 시킬 데이터를 불러옵니다.
X_test = pd.read_csv("X_test.csv")
X_train = pd.read_csv("X_train.csv")
y_train = pd.read_csv("y_train.csv")
# print(X_train)
# print(y_train)

# 2. 인덱스 제거
x_train2 = X_train.drop(columns='cust_id')
x_test2 = X_test.drop(columns='cust_id')

# 3. 정규화
from sklearn.preprocessing import MinMaxScaler

scaler = MinMaxScaler()
scaler.fit(x_train2)
x_train3 = scaler.transform(x_train2)
x_test3 = scaler.transform(x_test2)

# 4. 모델 생성
from sklearn.ensemble import RandomForestClassifier

model = RandomForestClassifier()

# 5. 모델 훈련
model.fit(x_train3, y_train)

# 6. 모델 예측
pred = model.predict(x_test3)

# 7. 제출
pd.DataFrame({'cust_id':X_test['cust_id'], 'label': pred}).to_csv('0000.csv', index=False)