import pandas as pd

# 데이터 불러오기
df = pd.read_csv('traffic_accident_stats.csv')

# 작업형1번의 문제2
# 문제: 주어진 데이터에서 연도별로 각 유형별 교통사고 검거율(검거건수 / 사고건수) 을 계산한 후,
# 각각의 연도에서 검거율이 가장 높은 교통사고 유형의 검거 건수를 연도별 각각 찾아서
# 그 건수를 모두 더해서 출력하시오 (정수형으로 출력합니다.)
df_사고 = df.loc[df['구분'] == '사고건수', : ]
df_검거 = df.loc[df['구분'] == '검거건수', : ]
df_사고_건수만 = df_사고.iloc[:, 2: ].reset_index()
df_검거_건수만 = df_검거.iloc[:, 2: ].reset_index()
df_검거율 = df_검거_건수만 / df_사고_건수만
df_검거율 # 무면허, 화물차사고, 보행자사고
a = df.loc[(df['연도'] == 2018) & (df['구분'] == '검거건수'), '무면허'].iloc[0]
b = df.loc[(df['연도'] == 2019) & (df['구분'] == '검거건수'), '화물차사고'].iloc[0]
c = df.loc[(df['연도'] == 2020) & (df['구분'] == '검거건수'), '보행자사고'].iloc[0]
ans = a + b + c
print(ans)


import pandas as pd

# 데이터 불러오기
df = pd.read_csv('traffic_accident_stats.csv')

# 작업형1번의 문제2
# 문제: 주어진 데이터에서 연도별로 각 유형별 교통사고 검거율(검거건수 / 사고건수) 을 계산한 후,
# 각각의 연도에서 검거율이 가장 높은 교통사고 유형의 검거 건수를 연도별 각각 찾아서
# 그 건수를 모두 더해서 출력하시오 (정수형으로 출력합니다.)
a = df.loc[df['구분'] == '검거건수', : ].set_index('연도').drop(columns='구분')
b = df.loc[df['구분'] == '사고건수', : ].set_index('연도').drop(columns='구분')

y = a / b
ans = 0
for year in range(2018, 2021):
  max_sago = y.loc[year, : ].idxmax()
  ans += df.loc[(df['구분'] == '검거건수') & (df['연도'] == year), max_sago].iloc[0]
print(ans)