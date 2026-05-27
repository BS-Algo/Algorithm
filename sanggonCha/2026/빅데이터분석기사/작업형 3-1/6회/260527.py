import pandas as pd

# 진통제 데이터를 정의합니다
df = pd.DataFrame({
    "진통제": [4, 4, 3, 4, 1, 4, 4, 1, 4, 4, 2, 1, 4, 2, 3, 2, 2, 4, 4, 4]
})

a = df.loc[df['진통제']==4, '진통제'].count() / len(df) # 진통제 건수 / 전체 건수

print(a)

# 답:

import pandas as pd

# 진통제 데이터를 정의
df = pd.DataFrame({
    "진통제": [4, 4, 3, 4, 1, 4, 4, 1, 4, 4, 2, 1, 4, 2, 3, 2, 2, 4, 4, 4]
})

# 관찰된 값 (각 부작용 발생 횟수)
o = df['진통제'].value_counts().sort_index()

# 예상 비율

# 1. 두통: 10%
# 2. 약간의 메스꺼움: 5%
# 3. 어지러움: 15%
# 4. 무증상: 70%
# -> [0.1, 0.05, 0.15, 0.7]

# 기대 값 계산 (예상비율 x 관찰된 값의 전체 건수)
e = [0.1 * 20, 0.05 * 20, 0.15 * 20, 0.7 * 20]

# 카이제곱 검정 실행
from scipy.stats import chisquare

stats, p_value = chisquare(o, e) 

# 검정 통계량 출력
print(stats)

#답:
print(p_value)
