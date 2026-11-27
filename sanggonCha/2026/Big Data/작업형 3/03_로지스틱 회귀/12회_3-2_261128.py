# 1. 데이터 불러오기
import pandas as pd
train = pd.read_csv('churn_train.csv')
test = pd.read_csv('churn_test.csv')

# ==============================================================================
# [분석 준비] 로지스틱 회귀 모델 학습
# ==============================================================================
# 종속변수: churn / 독립변수: age, tenure, monthly_fee, complaints (절편 포함)

# 모델 요약

# ==============================================================================
# [문항 1] 오즈비(Odds Ratio) 계산
# ==============================================================================
# complaints 가 1 증가할 때 이탈에 대한 오즈비를 구하시오.
# (소수 넷째 자리에서 반올림하여 셋째 자리까지)

import statsmodels.formula.api as smf
model = smf.logit('churn ~  age + tenure + monthly_fee + complaints', data=train).fit()

a = model.params['complaints']
odds = round(np.exp(a), 3)
print(odds)

# ==============================================================================
# [문항 2] 평가 데이터의 이탈 예측 확률 평균
# ==============================================================================
# 적합한 모형으로 평가 데이터의 이탈 확률을 예측하고, 예측 확률의 평균을 구하시오.
# (소수 넷째 자리에서 반올림하여 셋째 자리까지)

# 1. 평가 데이터의 예측 확률 계산 (statsmodels 의 predict 는 0/1 이 아니라 '확률'을 돌려준다)
pred = model.predict(test)
# 2. 예측 확률의 평균
ans = round(pred.mean(), 3)
print(ans)

# ==============================================================================
# [문항 3] 임계값 0.3 기준 accuracy
# ==============================================================================
# 예측 확률이 0.3 이상이면 1(이탈), 미만이면 0 으로 분류했을 때
# 평가 데이터의 accuracy 를 구하시오. (소수 넷째 자리에서 반올림하여 셋째 자리까지)

pred_class = (pred > 0.3).astype(int)
actual_class = test['churn']

from sklearn.metrics import confusion_matrix, accuracy_score, recall_score, precision_score
confusion_matrix(actual_class, pred_class)

ans2 = accuracy_score(actual_class, pred_class)
rs = recall_score(actual_class, pred_class) # 재현율, 민감도
ps = precision_score(actual_class, pred_class) # 정밀도
# 특이도는 직접 계산
print(rs)
print(ps)
print(ans2)