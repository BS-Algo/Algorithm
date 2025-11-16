#답:
import pandas as pd

# CSV 파일에서 데이터 로드
df = pd.read_csv('car_production_data.csv')
# df

# 각 공장에서 생산된 차량 수와 이송된 차량 수를 바탕으로 순수 생산량(생산된 차량 수 - 이송된 차량 수) 구하기
df['netOutput'] = df['Produced'] - df['Transferred']
# df

# 순수 생산량이 가장 많은 공장의 생산된 차량수를 구하기
result = df.loc[df['netOutput'].max() == df['netOutput'], 'Produced'].values[0]
print(result)

#자동차 제조 회사의 각 공장에서 생산된 차량 수와 이송된 차량 수를 바탕으로,
# 순수 생산량(생산된 차량 수 - 이송된 차량 수)

# 순수 생산량(생산된 차량 수 - 이송된 차량 수)이 가장 많은 공장의 생산된 차량수를 구하세요.
