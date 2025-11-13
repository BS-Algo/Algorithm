import pandas  as  pd

#1. 데이터 불러오기
df = pd.read_csv("city_temperature.csv", index_col=0)
# df

#2. 행번호를 컬럼으로 지정하기
# df2 = df.loc[2003, : ]
# df2
df = df.reset_index()
df.columns.values[0] = '년도'
# df

#3. 2003년도 행만 가져오기
# df2 
df_2003 = df.loc[df.년도 == 2003, : ]
# df_2003

#4. 2003년도 도시들의 평균온도 구하기
# mean = df2.mean()
# mean
mean_2003 = df_2003.iloc[ : , 1: ].mean(axis=1).values[0]
# mean_2003

#5. 평균온도보다 더 큰 도시수 구하기
answer = (df_2003.iloc[ : , 1: ] > mean_2003).sum(axis=1).values[0]
print(answer)