#답:
import pandas as pd

# CSV 파일에서 데이터 로드
df = pd.read_csv('employee_vo2max_data.csv')

# 직원들의 체력 측정 데이터를 바탕으로 VO2 Max 값을 계산하고,
df['V02 Max'] = 15 * (df['HRmax'] / df['HRrest'])


#우수한 체력: VO2 Max ≥ 40
#보통 체력: 30 ≤ VO2 Max < 40
regular_cnt = len(df.loc[(df['V02 Max'] >= 40), : ])
excellent_cnt = len(df.loc[(df['V02 Max'] >= 30) & (df['V02 Max'] < 40), : ])

# VO2 Max 수치가 우수한 체력인 사람과 보통 체력인 사람 수의 차이를 절대값으로 구하세요.
diff = abs(regular_cnt - excellent_cnt)
print(diff)
