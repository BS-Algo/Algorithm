# 작업 1) 연월별 매출 2위 찾기

import pandas as pd

df = pd.read_csv('sales_data.csv')
# 다음 순서대로 분석을 수행하시오.
# 1. date 컬럼을 datetime 형식으로 변환하시오
# 2. 각 연-월(YYYY-MM) 단위로 총 매출액을 계산하시오
# 3. 연월별 매출액을 내림차순으로 정렬하여, 2번째로 높은 매출액을 출력하시오
df['date'] = pd.to_datetime(df['date'], format='%Y년 %m월 %d일')
df['연월1'] = df['date'].dt.to_period('M')
df['연월2'] = df['date'].dt.strftime('%Y-%m')
ans = df.groupby('연월1')['price'].sum().sort_values(ascending=False)[1]
print(ans)

# 작업 2) 특정 시점의 인기 카테고리 분석

# 1.연월별 총 매출액을 기준으로 4번째로 높은 연-월을 찾으시오
# 2.해당 연-월의 데이터만 추출하시오
# 3.그 달에 카테고리별 매출액을 계산하시오
# 4.가장 높은 매출을 기록한 카테고리의 매출액을 출력하시오
m = df.groupby('연월1')['price'].sum().sort_values(ascending=False).head(4).index[-1]
ans2 = df.loc[df['연월1'] == m, :].groupby('category')['price'].sum().max()
print(ans2)
