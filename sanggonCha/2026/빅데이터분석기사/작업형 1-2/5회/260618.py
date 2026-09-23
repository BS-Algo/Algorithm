#문제

#  직원들의 체력 측정 데이터를 바탕으로 VO2 Max 값을 계산하고,
#  VO2 Max 수치가 우수한 체력인 사람과 보통 체력인 사람 수의 차이를 절대값으로 구하세요.

#  결과는 정수로 출력하세요.

# VO2 Max 계산 공식:

# VO2 Max = 15 * (HRmax / HRrest)

# VO2 Max 기준:

# 매우 낮음: VO2 Max < 20
# 낮음: 20 ≤ VO2 Max < 30
# 보통 체력: 30 ≤ VO2 Max < 40
# 우수한 체력: VO2 Max ≥ 40

#설명:

# HRmax: 최대 심박수
# HRrest: 안정 시 심박수

#답:
import pandas as pd

# CSV 파일에서 데이터 로드
df = pd.read_csv('employee_vo2max_data.csv')

# 직원들의 체력 측정 데이터를 바탕으로 VO2 Max 값을 계산하고,
df['VO2 Max'] = 15 * (df['HRmax'] / df['HRrest'])

# VO2 Max 수치가 우수한 체력인 사람과 보통 체력인 사람 수의 차이를 절대값으로 구하세요.
ex = len(df.loc[(df['VO2 Max'] >= 40 ), ])
no = len(df.loc[(df['VO2 Max'] >= 30 ) & (df['VO2 Max'] < 40), ])
#우수한 체력: VO2 Max ≥ 40
#보통 체력: 30 ≤ VO2 Max < 40

diff = abs(ex - no)
print(ans)