#답:
import pandas as pd

# CSV 파일에서 데이터 로드
df = pd.read_csv('employee_vo2max_data.csv')
df
# VO2 Max 계산 공식:
# VO2 Max = 15 * (HRmax / HRrest)
# 직원들의 체력 측정 데이터를 바탕으로 VO2 Max 값을 계산하고,
df['VO2_Max'] = 15 * (df['HRmax'] / df['HRrest'])
# VO2 Max 수치가 우수한 체력인 사람과 보통 체력인 사람 수의 차이를 절대값으로 구하세요.
excellent = len(df.loc[df['VO2_Max'] >= 40, :])
average = len( df.loc[(df['VO2_Max'] >= 30) & (df['VO2_Max'] < 40), : ] )
diff = excellent - average

# 결과는 정수로 출력하세요
print(abs(diff))
#우수한 체력: VO2 Max ≥ 40
#보통 체력: 30 ≤ VO2 Max < 40
