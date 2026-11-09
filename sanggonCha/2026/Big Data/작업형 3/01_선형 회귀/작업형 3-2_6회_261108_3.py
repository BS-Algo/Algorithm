# 다중 선형 회귀

# 문제:
# 주어진 데이터는 각 도시의 기후 요소(예: 강수량, 바람의 세기, 이산화탄소 농도)와
# 에너지 소비량(온도)입니다.

# 독립변수: rain(강수량), wind(바람의 세기), co2(이산화탄소 농도)
# 종속변수: energy(에너지 소비량)

# 1-1. 주어진 데이터를 바탕으로 다중 선형 회귀 모델을 구축하고,
#      독립변수인 이산화탄소 농도(CO2)의 회귀계수를 구하시오.

# 데이터 불러오기
# 답:
from statsmodels.formula.api import ols

# 데이터 불러오기
import pandas as pd
data = pd.read_csv("city_climate_energy_data.csv")

from statsmodels.formula.api import ols
model = ols('energy ~	rain + wind + co2', data=data).fit()
beta_co2 = model.params['co2']
print('beta_co2: ', beta_co2)

# 1-2.  데이터에서 'rain'과 'co2' 값을 고정한 상태에서, 'wind'의 세기가 증가함에 따라
#       'energy'가 감소하는지를 검증하기 위해 다중 선형 회귀 분석을 수행하고,
#       'wind'의 회귀 계수와 p-value 값을 구하십시오. 유의수준은 0.05 입니다.
beta_wind = model.params['wind']
pval_wind = model.pvalues['wind']
print('beta_wind: ', beta_wind)
print('pval_wind: ', pval_wind)

# 1-3. rain=50, wind=7, co2=400일 때 예측값과 그에 대한 95% 신뢰구간을 구하시오.

import pandas as pd
df4 = pd.DataFrame({
    'rain': [50],
    'wind': [7],
    'co2': [400]
})

df4_output = model.get_prediction(df4)
df4_summary = df4_output.summary_frame()
print(df4_summary['mean'][0], df4_summary['mean_ci_lower'][0], df4_summary['mean_ci_upper'][0])