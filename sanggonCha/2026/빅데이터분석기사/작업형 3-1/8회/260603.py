import pandas as pd

# 데이터 불러오기
df = pd.read_csv("sales_data.csv")
df
# pivot_table을 사용하여 매장코드별, 고객유형별 총매출액 합계 계산
df2 = df.pivot_table(values='총매출액', index='매장코드', columns='고객유형', aggfunc='sum', fill_value='') # 값, 행, 열, 함수, 결측치

# 고객유형 간 매출 차이 계산 및 절대값
# df2['diff'] = df2.iloc[ : , 1] - df2.iloc[ : , 2]
df2[0] = abs(df2.loc[ : , 1] - df2.loc[ : , 2])

# 차액 절대값이 가장 큰 매장코드 찾기
# a = df2.loc[ df2[0] == df2[0].max() ,  ].index[0]
a = df2[0].idxmax() # 둘다 가능
print(a)