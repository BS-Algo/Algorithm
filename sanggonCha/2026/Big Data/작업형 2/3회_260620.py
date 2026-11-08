# 문제:
# 문제: 특정 여행객 데이터셋을 바탕으로, 여행보험 상품 가입 여부를 예측하는 분류 모델을 구축하세요.
# 모델은 주어진 훈련 데이터를 사용하여 학습하고, 테스트 데이터를 사용하여 예측을 수행합니다.

# index 변수는 모델 학습에 포함되지 않도록 주의해야 합니다.

# 정답:

# 1. 데이터 불러오기
X_train = pd.read_csv('train_data.csv')
y_train = pd.read_csv('y_train.csv')
X_test = pd.read_csv('test_data.csv')

# 가입 여부 -> T or F -> RandomForestClassifier

# 0. 데이터 확인: 결측치 확인 및 인덱스 제거
# X_train.isnull().sum() # 전부 0
x_train2 = X_train.drop(columns='index')
x_test2 = X_test.drop(columns='index')

# 1. 데이터타입 확인 및 변환: 문자형이 있으면 pd.get_dummies()
# x_train2.info() # object 타입이 존재 -> pd.get_dummies() 로 변환
x_train3 = pd.get_dummies(x_train2)
x_test3 = pd.get_dummies(x_test2)

# 2. 정규화
from sklearn.preprocessing import MinMaxScaler

scaler = MinMaxScaler()
scaler.fit(x_train3)
x_train4 = scaler.transform(x_train3)
x_test4 = scaler.transform(x_test3)

# 3. 모델 생성
from sklearn.ensemble import RandomForestClassifier

model = RandomForestClassifier()

# 4. 모델 훈련
model.fit(x_train4, y_train)

# 5. 모델 예측
pred = model.predict(x_test4)

# 6. 제출
pd.DataFrame({'index': X_test['index'] , 'label': pred })