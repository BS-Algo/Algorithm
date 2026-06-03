import pandas as pd

# 데이터 불러오기
df = pd.read_csv('traffic_accident_stats.csv')
df
# 사고건수와 검거건수 분리
acc = df.loc[df['구분'] == '사고건수' , :].set_index('연도').drop(columns='구분')
arr = df.loc[df['구분'] == '검거건수' , :].set_index('연도').drop(columns='구분') # arrest: 체포하다, 검거하다

# 교통사고 유형별 검거율 계산
ratio = arr / acc

# 각 연도별 최고 검거율의 사고 유형과 그 사고 유형의 검거건수
ratio.loc[2018].idxmax()
ratio.loc[2019].idxmax()
ratio.loc[2020].idxmax()

total = 0
for year in ratio.index:
  total += arr.loc[year, ratio.loc[year].idxmax()]

print(total)