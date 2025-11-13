#답:
# ■ 시험문제 풀기 시작
# ▣ 빅데이터 분석 기사 실기 유형2번 코드 암기하기(분류 파트)

# 1. 기계 학습 시킬 데이터를 불러옵니다.
X_test = pd.read_csv("X_test.csv")
X_train = pd.read_csv("X_train.csv")
y_train = pd.read_csv("y_train.csv")

#print(X_train)
#print(y_train)

# 2. 데이터를 정규화 합니다.
from sklearn.preprocessing import MinMaxScaler

scaler = MinMaxScaler()
scaler.fit(X_train.drop(columns=['cust_id']))

x_train2 = scaler.transform(X_train.drop(columns=['cust_id']))
#print(x_train2)

x_test2 = scaler.transform(X_test.drop(columns=['cust_id']))
#print(x_test2)

# 3. 모델 생성
from sklearn.ensemble import RandomForestClassifier

model = RandomForestClassifier()

# 4. 모델 훈련
model.fit(x_train2, y_train)

# 5. 모델 예측
pred = model.predict(x_test2)
#print(pred)

# 6. 정답 제출
# 답안 제출 참고
pd.DataFrame({'cust_id': X_test.cust_id, 'label': pred }).to_csv('000090.csv', index=False)

#7. 모델 평가

from sklearn.metrics import accuracy_score

y_hat = model.predict(x_train2)

accuracy_score(y_hat, y_train)