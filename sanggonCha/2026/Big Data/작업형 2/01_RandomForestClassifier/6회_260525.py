# 필요한 라이브러리 임포트
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import f1_score

# 학습 데이터 불러오기 (train.csv)
train = pd.read_csv('train.csv')

# 1. 독립변수와 종속변수 분리
x = train.iloc[ :, 0:5]
y = train.iloc[ :, 5:]

# 2.결측치가 있는지 확인
x.isnull().sum()
y.isnull().sum()
 
# 3.훈련 데이터의 일부를 검증 데이터로 분리
from sklearn.model_selection import train_test_split
x_tr, x_ver, y_tr, y_ver = train_test_split(x, y, test_size=0.2, random_state=42)

# 4.랜덤 포레스트 모델 학습
from sklearn.ensemble import RandomForestClassifier

# 모델 생성
model = RandomForestClassifier(random_state=42)

# 모델 학습
model.fit(x_tr, y_tr)

# 5.검증 데이터 예측
y_pred = model.predict(x_ver)

# 6.f1 스코어 확인
from sklearn.metrics import f1_score
f1 = f1_score(y_ver, y_pred, average='weighted')
# average = 'weighted'는 다중 클래스 분류에서 F1 스코어와 같은 성능 지표를 계산할 때,
# 각 클래스의 중요도를 고려하여 계산하는 방식

# 7.테스트 데이터 불러오기
test = pd.read_csv('test.csv')

# 8.테스트 데이터 예측
pred = model.predict(test)

# 9.예측 결과 제출
submit = pd.DataFrame( { 'pred': pred } )
submit.to_csv('result.csv', index=False)