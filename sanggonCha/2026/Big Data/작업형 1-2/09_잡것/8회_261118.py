# 문제 2

# '전자 생산 비율'이 세 번째로 높은 국가의 '전자' 생산량을 x라고 정의하세요.
# '농업' 생산량이 세 번째로 높은 국가의 '농업' 생산량을 y라고 정의하세요.
# x와 y의 합을 구하세요.

# 총 생산량 = 전자 + 농업 + 선박 + 기타
# 전자 생산 비율 = 전자 / 총 생산량

import pandas as pd

# 데이터 불러오기
df = pd.read_csv("short_prod_data.csv")
df['Total'] = df['Elec'] + df['Agr'] + df['Ship'] + df['Oth']
df['Elec_ratio'] = df['Elec'] / df['Total']
x = df.sort_values(by='Elec_ratio', ascending=False)['Elec'].iloc[2]
y = df.sort_values(by='Agr', ascending=False)['Agr'].iloc[2]
ans = x + y
print(ans)