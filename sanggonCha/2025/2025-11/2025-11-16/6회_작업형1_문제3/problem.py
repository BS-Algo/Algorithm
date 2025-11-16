#답 :

#1. 데이터 불러오기
import pandas as  pd

df = pd.read_csv("sales_data.csv")
# df

# 연도별로 제품들의 총 월별 판매량(각 제품 판매량의 총합) 구하기
df['연도'] = df['날짜'].apply(lambda x: x[0:4]) # 날짜 컬럼에서 연도의 숫자만 필터링
df['월별 판매량'] = df.iloc[ : , 1:5].sum(axis=1)
# df

# 월별 판매량이 그 값이 가장 큰 연도를 찾기
# max_year = df.loc[ df['월별 판매량'] == df['월별 판매량'].max(), '연도'].values[0]
# max_year

result = df.groupby('연도')['월별 판매량'].sum().reset_index()
sorted_result = result.sort_values(by = '월별 판매량', ascending=False)
# sorted_result

# result = df.groupby('연도')['월별 판매량'].sum().reset_index()
# print(round(result['월별 판매량'].max() / 12))

# 해당 연도의 총판매량의 월평균값을 출력하기 (반올림하여 정수로 출력)
# result = df.loc[df['연도'] == max_year, '월별 판매량'].sum()

answer = sorted_result.loc[sorted_result['연도'] == '2021', '월별 판매량'].values[0] / 12
print(round(answer))