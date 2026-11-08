import pandas as pd

# 데이터 불러오기
df = pd.read_csv("short_prod_data.csv")
df
# 총 생산량 및 전자 생산 비율 계산
df['총 생산량'] = df['Elec'] + df['Agr'] + df['Ship'] + df['Oth'] 
df['전자 생산 비율'] = df['Elec'] / df['총 생산량']
third_elec_max_ctry = df.sort_values(by='전자 생산 비율', ascending=False).iloc[2, 0]

# 전자 생산 비율이 세 번째로 높은 국가
third_elec_max_ctry

# 농업 생산량이 세 번째로 높은 국가 선택
third_agr_max_ctry = df.sort_values(by='Agr', ascending=False).iloc[2, 0]
third_agr_max_ctry

# x와 y 정의 및 합 계산
x = df.loc[df['Ctry'] == third_elec_max_ctry, 'Elec'].iloc[0]
y = df.loc[df['Ctry'] == third_agr_max_ctry, 'Agr'].iloc[0]
ans = x + y
print(ans)
