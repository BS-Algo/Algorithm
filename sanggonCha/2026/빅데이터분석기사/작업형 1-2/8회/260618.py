# 문제 2

# '전자 생산 비율'이 세 번째로 높은 국가의 '전자' 생산량을 x라고 정의하세요.
# '농업' 생산량이 세 번째로 높은 국가의 '농업' 생산량을 y라고 정의하세요.

# x와 y의 합을 구하세요.

# 총 생산량 = 전자 + 농업 + 선박 + 기타

# 전자 생산 비율 = 전자 / 총 생산량

import pandas as pd

# 데이터 불러오기
df = pd.read_csv("short_prod_data.csv")

# 총 생산량 및 전자 생산 비율 계산
df['T'] = df['Elec'] + df['Agr'] + df['Ship'] + df['Oth']

# 전자 생산 비율이 세 번째로 높은 국가
df['ER'] = df['Elec'] / df['T']
df2 = df.sort_values(by='ER', ascending=False)
c1 = df2.iloc[2, 0]
x = df.loc[df['Ctry'] == c1, 'Elec'][0]
x

# 농업 생산량이 세 번째로 높은 국가 선택
df3 = df.sort_values(by='Agr', ascending=False)
y = df3.iloc[2, 2]

# x와 y 정의 및 합 계산
ans = x + y
print(ans)
