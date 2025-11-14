# 정답:

# 1. 데이터 불러오기
X_train = pd.read_csv('train_data.csv')
y_train = pd.read_csv('y_train.csv')
X_test = pd.read_csv('test_data.csv')
# X_train
# y_train
# 2.'index' 컬럼 제거
X_train2 = X_train.drop(columns=['index'])
X_test2 = X_test.drop(columns=['index'])
X_test2
 
# 3. 문자형 컬럼을 숫자로 변환합니다.
x_train3 = pd.get_dummies(X_train2)
x_test3 = pd.get_dummies(X_test2)


# 4. 데이터를 정규화합니다.
from sklearn.preprocessing import MinMaxScaler

scaler = MinMaxScaler()
scaler.fit(x_train3)
x_train4 = scaler.transform(x_train3)
# x_train4

# scaler.fit(x_test3)
x_test4 = scaler.transform(x_test3)
x_test4

# 5. 모델 생성
from sklearn.ensemble import RandomForestClassifier

model = RandomForestClassifier()

# 6. 모델 훈련
model.fit(x_train4, y_train)

# 7. 모델 예측
pred = model.predict(x_test4)
pred

# 8. 정답 제출
pd.DataFrame({'index': X_test['index'], 'label': pred}).to_csv('003000.csv', index=False)

# 9. 모델 평가
from sklearn.metrics import accuracy_score

y_hat = model.predict(x_train4)
accuracy_score(y_hat, y_train)