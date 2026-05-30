# # 문제 2

# '전자 생산 비율'이 세 번째로 높은 국가의 '전자' 생산량을 x라고 정의하세요.
# '농업' 생산량이 세 번째로 높은 국가의 '농업' 생산량을 y라고 정의하세요.

# x와 y의 합을 구하세요.

# 총 생산량 = 전자 + 농업 + 선박 + 기타

# 전자 생산 비율 = 전자 / 총 생산량

import pandas as pd

df = pd.read_csv("short_prod_data.csv")
df


import pandas as pd

# 데이터 불러오기
df = pd.read_csv("short_prod_data.csv")
df
# 총 생산량 및 전자 생산 비율 계산

# 전자 생산 비율이 세 번째로 높은 국가


# 농업 생산량이 세 번째로 높은 국가 선택

# x와 y 정의 및 합 계산

import pandas as pd

# 데이터 불러오기
df = pd.read_csv("short_prod_data.csv")
df

df['Total'] = df.iloc[ : , 1 : ].sum(axis=1)
df['Ratio'] = df['Elec'] / df['Total']
df_elec_ratio = df.sort_values('Ratio', ascending=False)
x = df_elec_ratio.iloc[2, 1]

df_elec = df.sort_values('Agr', ascending=False)
y = df_elec.iloc[2, 2]

s = x + y
print(s)