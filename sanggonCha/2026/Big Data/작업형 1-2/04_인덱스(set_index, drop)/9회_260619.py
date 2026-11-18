# 작업형1번의 문제2

# 문제: 주어진 데이터에서 연도별로 각 유형별 교통사고 검거율(검거건수 / 사고건수) 을 계산한 후,
# 각각의 연도에서 검거율이 가장 높은 교통사고 유형의 검거 건수를 연도별 각각 찾아서
# 그 건수를 모두 더해서 출력하시오 (정수형으로 출력합니다.)

import pandas as pd

# 데이터 불러오기
df = pd.read_csv('traffic_accident_stats.csv')

# 사고건수와 검거건수 분리
df_s = df.loc[df['구분'] == '사고건수', :].copy().set_index('연도').drop(columns='구분')
df_g = df.loc[df['구분'] == '검거건수', :].copy().set_index('연도').drop(columns='구분')

# 교통사고 유형별 검거율 계산
df_r = df_g / df_s

# 각 연도별 최고 검거율의 사고 유형과 그 사고 유형의 검거건수
ans = 0
for y in df_r.index:
  s = df_r.loc[y, : ].idxmax()
  g = df_g.loc[y, s]
  ans += g
print(ans)