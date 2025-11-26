#답 :

#1. 데이터 불러오기
import pandas as  pd

df = pd.read_csv("sales_data.csv")
# df

# 연도별로 제품들의 총 월별 판매량(각 제품 판매량의 총합) 구한 후 그 값이 가장 큰 연도를 찾아,
df['연도'] = df['날짜'].apply(lambda x: x[0:4])
df['월 판매량'] = df.iloc[ : , 1:-1].sum(axis=1)
# df
df2 = df.groupby('연도')['월 판매량'].sum().reset_index()
max_idx = df2['월 판매량'].idxmax()

# 해당 연도의 총판매량의 월평균값을 출력하세요. (반올림하여 정수로 출력)
max_year_total_volumes = df2.loc[max_idx, '월 판매량']
max_year_total_volumes_mean = max_year_total_volumes / 12
answer = round(max_year_total_volumes_mean)
print(answer)