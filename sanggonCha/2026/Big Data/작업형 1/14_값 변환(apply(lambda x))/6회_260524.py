#답 :

#1. 데이터 불러오기
import pandas as  pd

df = pd.read_csv("sales_data.csv")

# 연도별로 제품들의 총 월별 판매량(각 제품 판매량의 총합) 구하기
df['판매량 총합'] = df['전자제품'] + df['가전제품'] + df['의류'] + df['잡화']

df['날짜'] = df['날짜'].apply(lambda x: x[0:4])

# 월별 판매량 값이 가장 큰 연도 찾기
df2 = df.groupby('날짜')['판매량 총합'].sum()
df2
max_year = df2.idxmax()

# 해당 연도의 총판매량의 월평균값을 출력하세요. (반올림하여 정수로 출력)
total_sales_volume = df2[max_year]
mean_sales_volume = total_sales_volume / 12
mean_sales_volume
print(round(mean_sales_volume))
