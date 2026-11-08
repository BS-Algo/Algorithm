# 카이제곱 검정: 빈도를 검정

# 1-1. 진통제를 투여 받은 환자 중 '무증상'의 비율을 0과 1 사이로 구하시오.
import pandas as pd

# 진통제 데이터를 정의합니다
df = pd.DataFrame({
    "진통제": [4, 4, 3, 4, 1, 4, 4, 1, 4, 4, 2, 1, 4, 2, 3, 2, 2, 4, 4, 4]
})

ratio_4 = len(df.loc[df['진통제'] == 4, '진통제']) / len(df)
print(ratio_4)

# 1-2. 항히스타민제의 예상 부작용 비율과 진통제의 부작용 관찰값이 통계적으로 유의미하게 차이가 있는지 확인하시오.
#      카이제곱 검정을 사용하여 검정 통계량을 구하시오.

# 답:

import pandas as pd

# 진통제 데이터를 정의
df = pd.DataFrame({
    "진통제": [4, 4, 3, 4, 1, 4, 4, 1, 4, 4, 2, 1, 4, 2, 3, 2, 2, 4, 4, 4]
})

observe = df['진통제'].value_counts().sort_index()

# 관찰된 값 (각 부작용 발생 횟수)

# 예상 비율

# 1. 두통: 10%
# 2. 약간의 메스꺼움: 5%
# 3. 어지러움: 15%
# 4. 무증상: 70%


# 기대 값 계산 (예상비율 x 관찰된 값의 전체 건수)
expect = [0.1 * 20, 0.05 * 20, 0.15 * 20, 0.7 * 20]
expect

# 카이제곱 검정 실행
from scipy.stats import chisquare
stats, p_value = chisquare(observe, expect)

# 검정 통계량 출력
print(stats)


# 1-3. 위의 p-값을 구하시오.
print(p_value)