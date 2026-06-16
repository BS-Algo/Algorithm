# 데이터 불러오기
import pandas as pd
df = pd.read_csv("factory_data.csv")
df
# 1. 작업 공정의 최빈값 계산
mode_value = df['작업공정'].mode()[0]

# 2. 작업 공정 결측치 처리: 최빈값으로 대체
df['작업공정'] = df['작업공정'].fillna(mode_value)

# # 3. 작업 공정별 작업 시간 평균 계산
df_gr = df.groupby('작업공정')['작업시간'].transform('mean')

# 4. 작업 시간 결측치를 해당 작업 공정 평균으로 대체
df['작업평균 시간'] = df_gr
df['작업시간'] = df['작업시간'].fillna(df_gr)
df
# # 5. 다음의 값을 각각 구합니다.
# long_time: 작업 시간이 가장 긴 값
# long_time_cnt: 작업 시간이 가장 긴 값인 기계 수
a = df['작업시간'].max()
b = len(df.loc[ df['작업시간'] == df['작업시간'].max(), :])

# # 6. 작업 시간이 가장 긴 값 + 작업 시간이 가장 긴 값인 기계 수
ans = a + b
print(ans)