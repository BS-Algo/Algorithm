# 필요한 라이브러리 임포트
import pandas as pd

# 자동차의 연비 예측을 위해 주어진 데이터셋을 활용하여 모델을 구축하세요.
# 데이터셋은 각 자동차의 특성(예: 차량_연식, 주행거리, 연료비, 엔진 크기, 차량 무게)을 포함하고 있습니다.

# 학습 데이터 불러오기 (train.csv)
train = pd.read_csv('train.csv')
test = pd.read_csv('test.csv')
x = train.iloc[:, :-1]
y = train.iloc[:, -1]

# 정규화 선택적(RandomForestClassifier 하면 이미 포함됨)
# 훈련, 검증 데이터 선택적(문제에서 하라고 하지 않은 이상 필수 아님)
from sklearn.model_selection import train_test_split
x_tra, x_tes, y_tra, y_tes = train_test_split(x, y, test_size=0.4, random_state=42)

from sklearn.ensemble import RandomForestClassifier
model = RandomForestClassifier()
model.fit(x_tra, y_tra)

# f1 스코어 검증(문제에서 하라고 하지 않은 이상 필수 아님)
from sklearn.metrics import f1_score
y_pred = model.predict(x_tes)
score = f1_score(y_tes, y_pred)

pred = model.predict(test)
pd.DataFrame({'pred': pred}).to_csv('수험번호.csv', index=False)