# 문제:

# 한 자동차 회사는 새로운 마케팅 전략을 수립하기 위해 고객을 4개의 세분화된 시장으로 나누었습니다.
# 기존 고객 데이터를 바탕으로 신규 고객이 어떤 세분화된 시장(Segmentation: 1, 2, 3, 4)에 속할지
# 예측하는 모델을 구축하세요.


# 1. 기계 학습 시킬 데이터를 불러옵니다.
X_train = pd.read_csv('train.csv')
y_train = pd.read_csv('y_train.csv')
X_test = pd.read_csv('test.csv')

# 데이터 분류 -> RandomForestClassifier

# 0. 데이터 확인: 결측치 및 인덱스 제거
# X_train.isnull().sum() # 0
x_train2 = X_train.drop(columns='ID')
x_test2 = X_test.drop(columns='ID')

# 1. 데이터 변환: 문제 데이터 변환(pd.get_dummies()) 및 독립·종속 변수 분리
# 모두 숫자형 데이터

# 2. 정규화
from sklearn.preprocessing import MinMaxScaler

scaler = MinMaxScaler()

scaler.fit(x_train2)
x_train3 = scaler.transform(x_train2)
x_test3 = scaler.transform(x_test2)

# 3. 모델 생성
from sklearn.ensemble import RandomForestClassifier

model = RandomForestClassifier()

# 4. 모델 훈련
model.fit(x_train3, y_train)

# 5. 모델 예측
pred = model.predict(x_test3)

# 6. 제출
pd.DataFrame({'index': X_test['ID'], 'label': pred}).to_csv('0000.csv', index=False)