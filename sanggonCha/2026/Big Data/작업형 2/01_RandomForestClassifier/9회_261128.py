# =============================================================================
# ■ 작업형 2 (다중 분류 문제: 농약 검출 여부 예측)
# =============================================================================
# [문제 설명]

# - 데이터셋 구성: 연도, 작물 유형, 온도, 습도, 지역명, 농약 종류, 농약 사용량, 농약 빈도, 토양유형 등
# - 종속변수: 농약검출여부 (0, 1, 2)
# - 목표: 주어진 데이터를 바탕으로 농약 검출 여부를 예측하는 분류 모델을 구축하시오.
# - 평가지표: macro F1 Score (모델 성능 비교 시 참고)
#답 :
import pandas as pd

# 저장된 CSV 파일 불러오기
train = pd.read_csv("농약_train.csv")
test = pd.read_csv("농약_test.csv")

train2 = train.drop(columns='연도')
test2 = test.drop(columns='연도')

x2 = train2.iloc[:, :-1]
y2 = train2.iloc[:, -1]

x_total = pd.concat([x2, test2])
x_total2 = pd.get_dummies(x_total)

x3 = x_total2.iloc[:len(x2), :]
test3 = x_total2.iloc[len(x2):, :]

from sklearn.ensemble import RandomForestClassifier
model = RandomForestClassifier()
model.fit(x3, y2)

pred = model.predict(test3)