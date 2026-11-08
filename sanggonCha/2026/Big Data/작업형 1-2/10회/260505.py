# 📝 제1유형.문제2
# 📌 시나리오
# 한 소매 유통 기업에서 지난 2년간의 매출 데이터를 분석하여 시즌별 트렌드를 파악하고자 합니다. 데이터가 수기로 기록된 탓에 날짜 형식이 한국식('YYYY년 MM월 DD일')으로 되어 있어 전처리가 필요한 상황입니다. 다음의 작업 순서데로 매출액을 출력하세요
# 작업 1) 연월별 매출 2위 찾기
# 문제
# 다음 순서대로 분석을 수행하시오.
# 1. date 컬럼을 datetime 형식으로 변환하시오
# 2. 각 연-월(YYYY-MM) 단위로 총 매출액을 계산하시오
# 3. 연월별 매출액을 내림차순으로 정렬하여, 2번째로 높은 매출액을 출력하시오

# 작업 1) 연월별 매출 2위 찾기

import pandas as pd

df = pd.read_csv('sales_data.csv')
# df.info()
# df

#1. date 컬럼을 datetime 형식으로 변환하시오
df['date'] = pd.to_datetime(df['date'], format='%Y년 %m월 %d일')
# df


# 2. 각 연-월(YYYY-MM) 단위로 총 매출액을 계산하시오
df['year_month'] = df['date'].dt.strftime('%Y-%m')
연월별매출 = df.groupby('year_month')['price'].sum()

#3.  연월별 매출액을 내림차순으로 정렬하여, 2번째로 높은 매출액을 출력하시오
연월별매출_내림차순 = 연월별매출.sort_values(ascending=False)
print(연월별매출_내림차순[1])

# 작업 2) 특정 시점의 인기 카테고리 분석
# 문제
# 다음 순서대로 분석을 수행하시오.
# 1.연월별 총 매출액을 기준으로 4번째로 높은 연-월을 찾으시오
# 2.해당 연-월의 데이터만 추출하시오
# 3.그 달에 카테고리별 매출액을 계산하시오
# 4.가장 높은 매출을 기록한 카테고리의 매출액을 출력하시오


# 작업 2) 특정 시점의 인기 카테고리 분석

# 1. 4번째로 높은 연-월 찾기
df['date'] = pd.to_datetime(df['date'], format='%Y년 %m월 %d일')
df['year_month'] = df['date'].dt.strftime('%Y-%m')

# 2. 해당 연-월 데이터 추출
연월별_매출액 = df.groupby('year_month')['price'].sum()
연월별_매출액_정렬 = 연월별_매출액.sort_values(ascending=False)
연월별_매출액_정렬 # 2023-03 

# 3. 카테고리별 매출액 계산
df2 = df.loc[df['year_month'] == '2023-03', ['year_month', 'price', 'category']]
df3 = df2.groupby('category')['price'].sum()

# # 4. 최대 매출 카테고리의 매출액 출력
df4 = df3.sort_values(ascending=False)
print(df4[0])
