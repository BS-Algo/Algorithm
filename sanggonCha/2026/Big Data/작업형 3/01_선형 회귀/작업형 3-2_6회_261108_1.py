# 다중 선형 회귀

# 문제:
# 주어진 데이터는 각 도시의 기후 요소(예: 강수량, 바람의 세기, 이산화탄소 농도)와
# 에너지 소비량(온도)입니다.

# 독립변수: rain(강수량), wind(바람의 세기), co2(이산화탄소 농도)
# 종속변수: energy(에너지 소비량)

# 1-1. 주어진 데이터를 바탕으로 다중 선형 회귀 모델을 구축하고,
# 독립변수인 이산화탄소 농도(CO2)의 회귀계수를 구하시오.

# 다중 선형 회귀 모델을 구축
from statsmodels.formula.api import ols
model = ols('energy ~ rain + wind +	co2	', data=data).fit()

# 독립변수인 이산화탄소 농도(CO2)의 회귀계수
# model.summary()
beta1 = model.params['co2']
print(beta1)

# 1-2.  데이터에서 'rain'과 'co2' 값을 고정한 상태에서, 'wind'의 세기가 증가함에 따라
#       'energy'가 감소하는지를 검증하기 위해 다중 선형 회귀 분석을 수행하고,
#       'wind'의 회귀 계수와 p-value 값을 구하십시오. 유의수준은 0.05 입니다.

# 답:
print(model.params['wind'])
print(model.pvalues['wind'])

# 1-3. rain=50, wind=7, co2=400일 때 예측값과 그에 대한 95% 신뢰구간을 구하시오.
#답:
import pandas as pd

new_data = pd.DataFrame({
    'rain': [50],
    'wind': [7],
    'co2': [400]
})

pred = model.get_prediction(new_data)
pred2 = pred.summary_frame()

pre_val = pred2['mean'][0]
pre_low = pred2['mean_ci_lower'][0]
pre_upp = pred2['mean_ci_upper'][0]

print(pre_val)
print(pre_low)
print(pre_upp)