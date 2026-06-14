import pandas  as  pd

#1. 데이터 불러오기
df = pd.read_csv("city_temperature.csv", index_col=0)

#2. 행번호를 컬럼으로 지정하기

#3. 2003년도 행만 가져오기
df_2003 = df.loc[2003]

#4. 2003년도 도시들의 평균온도 구하기
mean_2003 = df_2003.mean()

#5. 평균온도보다 더 큰 도시수 구하기
ans = sum(df_2003 > mean_2003)
print(ans)