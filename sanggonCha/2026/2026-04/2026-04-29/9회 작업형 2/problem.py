# 작업형1번의 문제3

# 주어진 데이터에서

# 작업 공정이 결측치인 경우, 작업 공정 중 최빈값으로 결측치를 대체합니다.

# 작업 시간이 결측치인 경우, 해당하는 작업 공정의 작업 시간 평균값으로 결측치를 대체합니다.

# 결측치를 모두 대체한 후, 다음 값을 구합니다:

# 1.작업 시간중 가장 긴 값
# 2.작업 시간이 가장 긴 값인 기계 수
 
# 작업 시간이 가장 긴 값 + 작업 시간이 가장 긴 값인 기계 수 값을 출력하세요.

# 데이터 불러오기
import pandas as pd
df = pd.read_csv("factory_data.csv")
df
# 1. 작업 공정의 최빈값 계산
df['작업공정'].mode()[0] # 최빈값 계산: 'A'

# 2. 작업 공정 결측치 처리: 최빈값으로 대체
df['작업공정'] = df['작업공정'].fillna('A')
# df.isnull().sum()

# 3. 작업 공정별 작업 시간 평균 계산
group_mean = df.groupby('작업공정')['작업시간'].transform('mean')

# 4. 작업 시간 결측치를 해당 작업 공정 평균으로 대체
df['작업별 평균 시간'] = group_mean
df['작업시간'] = df['작업시간'].fillna(group_mean)
# df

# 5. 다음의 값을 각각 구합니다.
# long_time: 작업 시간이 가장 긴 값
# long_time_cnt: 작업 시간이 가장 긴 값인 기계 수
long_time = df['작업시간'].max()
# long_time
long_time_cnt = (df['작업시간'] == long_time).sum()

# 6. 작업 시간이 가장 긴 값 + 작업 시간이 가장 긴 값인 기계 수
answer = long_time + long_time_cnt
print(answer)