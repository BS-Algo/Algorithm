# 문제:

# 자동차 제조 회사의 각 공장에서 생산된 차량 수와 이송된 차량 수를 바탕으로,
# 순수 생산량(생산된 차량 수 - 이송된 차량 수)이 가장 많은 공장의 생산된 차량수를 구하세요.

# 데이터 설명:

# car_production_data.csv 파일에는 각 공장의 생산된 차량 수(Produced),
# 이송된 차량 수(Transferred), 그리고 공장명(Factory) 정보가 포함되어 있습니다.

#답:
import pandas as pd

# CSV 파일에서 데이터 로드
df = pd.read_csv('car_production_data.csv')

#자동차 제조 회사의 각 공장에서 생산된 차량 수와 이송된 차량 수를 바탕으로,
# 순수 생산량(생산된 차량 수 - 이송된 차량 수)
df['순수 생산량'] = df['Produced'] - df['Transferred']

# 순수 생산량(생산된 차량 수 - 이송된 차량 수)이 가장 많은 공장의 생산된 차량수를 구하세요.
ans = df.iloc[df['순수 생산량'].idxmax(), 1]
print(ans)