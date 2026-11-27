import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import f1_score

# 0. 데이터 불러오기
train = pd.read_csv("train.csv")
test = pd.read_csv("test.csv")
train.shape
test.shape

# 고객 서비스 만족도 예측 모델 개발
# 주어진 학습용 데이터(train.csv)를 활용하여 고객의 서비스 만족도(Target)를 예측하는 모델을 구축하고, 이를 바탕으로 평가용 데이터(test.csv)의 만족도 예측 결과를 csv 파일로 제출하시오.

x = train.iloc[:, :-2]
y = train.iloc[:, -2]
test2 = test.drop(columns='ID')

from sklearn.ensemble import RandomForestClassifier
model = RandomForestClassifier()
model.fit(x, y)

pred = model.predict(test2)
pd.DataFrame({'ID': test['ID'], 'pred': pred}).to_csv('result.csv', index=False)