import pandas as pd

# 데이터 불러오기
df = pd.read_csv("short_prod_data.csv")

# 총 생산량 및 전자 생산 비율 계산
df['total'] = df['Elec'] + df['Agr'] + df['Ship'] + df['Oth']
df['elec_ratio'] = df['Elec'] / df['total']

# 전자 생산 비율이 세 번째로 높은 국가
df_elec = df.sort_values(by='elec_ratio', ascending=False)
third_elec_country = df_elec.iloc[2:3, :]


# 농업 생산량이 세 번째로 높은 국가 선택
df_agr = df.sort_values(by='Agr', ascending=False)
third_agr_country = df_agr.iloc[ 2:3 , :]

# x와 y 정의 및 합 계산
x = third_elec_country['Elec'].values[0]
y = third_agr_country['Agr'].values[0]
print(x + y)