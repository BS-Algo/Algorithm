#문제1. 학습용 데이터로 주택 가격 예측 다중회귀 모델을 구축한 후,
#        p-value가 0.05보다 작은(통계적으로 유의미한) 독립변수(상수항 제외)의 개수를 구하시오.
# 답:

# 훈련 데이터
train_reg = df_reg.iloc[:140].reset_index(drop=True)

# 테스트 데이터
test_reg = df_reg.iloc[140:].reset_index(drop=True)

train_reg

x = train_reg.iloc[:, 1:]
y = train_reg.iloc[:, 0]

import statsmodels.api as sm
x = sm.add_constant(x)

model = sm.OLS(y, x).fit()
model.summary()
ans = (model.pvalues.drop('const') < 0.05).sum()
print(ans)

#문제2.  학습용 데이터에서 주택 가격에 가장 큰 영향을 미치는 독립변수 2개만 사용하여
#        모델을 구축하고, 학습용 데이터의 실제 주택 가격과 예측 주택 가격의 피어슨 상관계수를 소수
#        셋째 자리까지 구하시오.

# 답:

model.summary() # coef
i = abs(model.params.drop('const')).sort_values(ascending=False).head(2).index
i # 'house_age', 'distance_to_center'
x2 = train_reg.loc[:, i]
x3 = sm.add_constant(x2)

model2 = sm.OLS(y, x3).fit()
y_pred = model2.predict(x3)

from scipy.stats import pearsonr
stats, pvalue = pearsonr(y, y_pred)
ans = round(stats, 3)
print(ans)

#문제3. 문제 2에서 구축한 모델을 사용하여 평가용 데이터에 대한 주택 가격 예측값과
#       실제 주택 가격을 비교해 RMSE(Root Mean Squared Error)를 소수 셋째 자리까지 구하시오.
# 답:


import statsmodels.api as sm

test2 = test_reg.loc[: , i]
test3 = sm.add_constant(test2)
y_pred_test = model2.predict(test3)

from sklearn.metrics import root_mean_squared_error
ans2 = round(root_mean_squared_error(y_pred_test, test_reg['house_price']), 3)
print(ans2)