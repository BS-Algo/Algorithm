#답:
import pandas as pd

# CSV 파일에서 데이터 로드
df = pd.read_csv('employee_vo2max_data.csv')
# df

# 직원들의 체력 측정 데이터를 바탕으로 VO2 Max 값을 계산하고,
df['VO2 Max'] = 15 * (df['HRmax'] / df['HRrest'])
# df

# VO2 Max 수치가 우수한 체력인 사람과 보통 체력인 사람 수의 차이를 절대값으로 구하세요.
moderate = len(df.loc[(df['VO2 Max'] >= 30) & (df['VO2 Max'] < 40 ), : ])
excellent = (df['VO2 Max'] >= 40).sum()
# excellent
result = abs(moderate- excellent)
print(result)

#우수한 체력: VO2 Max ≥ 40
#보통 체력: 30 ≤ VO2 Max < 40
