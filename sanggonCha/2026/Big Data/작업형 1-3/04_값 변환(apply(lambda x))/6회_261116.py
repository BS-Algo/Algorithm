#답 :

#1. 데이터 불러오기
import pandas as  pd

df = pd.read_csv("sales_data.csv")

#문제:

# 연도별로 제품들의 총 월별 판매량(각 제품 판매량의 총합) 구한 후 그 값이 가장 큰 연도를 찾아,
# 해당 연도의 총판매량의 월평균값을 출력하세요. (반올림하여 정수로 출력)
df['총합'] = df['전자제품'] + df['가전제품'] + df['의류'] + df['잡화']
df['날짜'] = df['날짜'].apply(lambda x : x[0:4])
df2 = df.groupby('날짜')['총합'].sum()
ans = round(df2.max() / 12)
print(ans)