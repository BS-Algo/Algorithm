# 필요한 라이브러리 임포트
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import f1_score

import pandas as pd
from sklearn.model_selection import train_test_split # 주어진 데이터를 8:2로 훈련 데이터와 테스트 데이터로 나누기 위해
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import f1_score # 훈련 데이터의 일부 -> 모델 학습 -> 검증 데이터로 평가

# 학습 데이터 불러오기 (train.csv)
train = pd.read_csv('train.csv')
train # 연비: 종속 변수

# 1.독립변수와 종속변수 분리
x = train.iloc[ : , :-1] # 독립변수: 나머지
# x
y = train.iloc[ : , -1] # 종속변수: 연비
# y 

# 2.결측치가 있는지 확인
x.isnull().sum() # 결측치 개수 확인
y.isnull().sum() # 결측치 개수 확인


# 3.훈련 데이터의 일부를 검증 데이터로 분리
x_tr, x_val, y_tr, y_val = train_test_split(x, y, test_size=0.2, random_state=42) # 독립변수, 종속변수, 테스트용 데이터 크기, 임의의 숫자
# 독립변수 훈련 데이터, 독립변수 테스트 데이터, 종속변수 훈련 데이터, 종속변수 테스트 데이터
print(x_tr.shape)
print(x_val.shape)
print(y_tr.shape)
print(y_val.shape)

# 4.랜덤 포레스트 모델 학습
model = RandomForestClassifier(random_state=42)
model.fit(x_tr, y_tr) # 최댓값 최솟값 기억

# 5.검증 데이터 예측
y_pred = model.predict(x_val)
y_pred

# 6.f1 스코어 확인
f1 = f1_score(y_val, y_pred, average='weighted') # weighted는 다중 클래스 분류에서 F1 스코어와 같은 성능 지표를 계산할 때, 각 클래스의 중요도를 고려하여 계산하는 방식
f1

# 7.테스트 데이터 불러오기
test = pd.read_csv('test.csv')
# test

# 8.테스트 데이터 예측
pred = model.predict(test)
pred

# 9.예측 결과 제출
submit = pd.DataFrame( {'pred': pred} )
submit.to_csv('result.csv', index=False)