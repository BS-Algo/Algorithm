# 로지스틱 회귀

# 📌 시나리오
# 당뇨병 발병 여부 예측 모델(Logistic Regression) 분석
# 주어진 데이터(data_t3_q1_lower.csv)를 이용하여 diabetes를 종속변수로, blood_sugar와 membership을 독립변수로 하는 로지스틱 회귀분석을 수행하고 다음 물음에 답하시오.

# - 종속변수(y) : diabetes (0: 정상, 1: 당뇨)
# - 독립변수(x) : blood_sugar(혈당), membership(건강관리 프로그램 회원등급)
# membership = 'no' (기준 범주)
# 어떤 프로그램에도 미가입 상태 일반 대조군
# membership = 'yes'
# 유료 회원 (Premium/Paid membership)
# 정식 건강관리 프로그램 가입자
# 적극적인 건강관리 참여자
# membership = 'free'
# 무료 체험 회원
# 기본 건강정보만 제공받는 회원
# 제한적 서비스 이용자

# 참고 : statsmodels 패키지를 활용하고, 범주형 변수인 membership은 'no' 를 기준(Reference)으로 설정하여 분석하시오.

# [문항 1] 오즈비(Odds Ratio) 계산: membership이 'yes' 인 경우의 오즈비를 구하는데, 
# 기준값('no') 대비 당뇨병 발병의 오즈비(Odds Ratio) 를 구하시오. 
# (답안은 소수점 셋째 자리에서 반올림하여 둘째 자리까지 출력하시오.)

# 1. 데이터 불러오기
df = pd.read_csv('data_t3_q1_lower.csv')
df.head(20)

import pandas as pd
df2 = pd.get_dummies(df, columns=['membership'], drop_first=False, dtype=int)
df2

import statsmodels.api as sm

y = df2['diabetes']
x = df2[['blood_sugar', 'membership_free', 'membership_yes']]
X = sm.add_constant(x)

model = sm.Logit(y, X).fit()

model.summary()

coef_yes = model.params['membership_yes']

import numpy as np
print(round(np.exp(coef_yes), 2))


# [문항 2] 최고 발병 확률 대상자의 혈당 찾기 구축된 모델을 통해 예측했을 때, 
# 당뇨병 발병 확률(Probability) 이 가장 높은 데이터(행)를 찾고, 해당 데이터의 blood_sugar 수치를 구하시오. 
# (답안은 소수점 셋째 자리에서 반올림하여 둘째 자리까지 출력하시오.)

# ==============================================================================
# [문항 2] 최고 발병 확률 대상자의 혈당 찾기

# 구축된 모델을 통해 예측했을 때,
# 당뇨병 발병 확률(Probability) 이 가장 높은 데이터(행)를 찾고,
# 해당 데이터의 blood_sugar 수치를 구하시오.
# (답안은 소수점 셋째 자리에서 반올림하여 둘째 자리까지 출력하시오.)
# ==============================================================================

df2['prob'] = model.predict(X)

max_idx = df2['prob'].idxmax()

blood_val = df2['blood_sugar'][max_idx]

print(round(blood_val, 2))


# [문항 3] 민감도(Sensitivity) 계산 모델의 예측 확률(cutoff = 0.5)을 기준으로 
# 혼동 행렬(Confusion Matrix)을 만들었을 때, 민감도(Sensitivity) 를 구하시오. 
# (답안은 소수점 셋째 자리에서 반올림하여 둘째 자리까지 출력하시오.)

from sklearn.metrics import confusion_matrix, recall_score

# 예측 클래스
pred_class = (model.predict(X) >= 0.5).astype(int)

# 실제 정답
actual_class = y

# 혼동 행렬
cm = confusion_matrix(actual_class, pred_class)

print(cm)

# 민감도
result = round(recall_score(actual_class, pred_class), 2)

from sklearn.metrics import confusion_matrix, recall_score

# 예측 값
pred_class = (model.predict(X) > 0.5).astype(int)

# 실제 값
actual_class = y

# 혼동 행렬(confusion maxtrix) 구하기
cm = confusion_matrix(actual_class, pred_class)
print(cm)

# 민감도(재현율, recall) 구하기
recall_val = round(recall_score(actual_class, pred_class), 2)
print(recall_val)