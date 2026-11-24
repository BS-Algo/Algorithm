# 문제:

# 자동차의 연비 예측을 위해 주어진 데이터셋을 활용하여 모델을 구축하세요.
# 데이터셋은 각 자동차의 특성(예: 차량_연식, 주행거리, 연료비, 엔진 크기, 차량 무게)을 포함하고 있습니다.
# 연비는 세 가지 범주로 분류됩니다.

# 1. 고연비: 매우 경제적인 차량
# 2. 중간연비: 적당한 경제성을 가진 차량
# 3. 저연비: 경제적이지 않은 차량

# 모델의 평가는 f1 score 로 평가됩니다.
# 훈련 데이터: train.csv
# 테스트 데이터 : test.csv

# 학습 데이터 불러오기 (train.csv)
train = pd.read_csv('train.csv')
test = pd.read_csv('test.csv')

x = train.iloc[: , :-1]
y = train.iloc[: , -1]

from sklearn.model_selection import train_test_split
x_tr, x_val, y_tr, y_val = train_test_split(x, y, test_size=0.2)

from sklearn.ensemble import RandomForestClassifier
model = RandomForestClassifier()
model.fit(x_tr, y_tr)
y_pred = model.predict(x_val)

from sklearn.metrics import f1_score

f1 = f1_score(y_pred, y_val, average='micro') # 
f1 = f1_score(y_pred, y_val, average='macro') # 전체 균일
f1 = f1_score(y_pred, y_val, average='weighted') # 가중치 만큼

print(f1)

pred = model.predict(test)
pd.DataFrame({'pred': pred}).to_csv('수험번호.csv', index=False)