# ==============================================================================
# [문항 1] 단일표본 t검정
# ==============================================================================
# 표본 60명 전체의 post_score로 이 학교 학생 전체의 사후 평균(모평균)이
# 70점과 다른지 단일표본 t검정을 수행하고 p-value를 구하시오.
# (소수 다섯째 자리에서 반올림하여 넷째 자리까지)

# 1. 데이터 불러오기
import pandas as pd
from scipy import stats
df = pd.read_csv('ttest_score.csv')

from scipy import stats
s, p = stats.ttest_1samp(df['post_score'], 70)
ans1 = round(p, 4)
print(ans1)

# ==============================================================================
# [문항 2] 대응표본 t검정
# ==============================================================================
# 전체 학생을 대상으로 post_score − pre_score 에 대한 대응표본 t검정을 수행하고
# 검정통계량을 구하시오. (소수 넷째 자리에서 반올림하여 셋째 자리까지)

# 1. 대응표본 t검정
#    ttest_rel(사후, 사전) → 문제의 "사후 − 사전" 순서 그대로 넣는다

from scipy import stats
s, p = stats.ttest_rel(df['post_score'], df['pre_score'])
ans2 = round(s, 3)
print(ans2)

# ==============================================================================
# [문항 3] 독립표본 t검정 (등분산 가정) → 95% 신뢰구간
# ==============================================================================
# A반과 B반의 post_score 에 대해 등분산을 가정한 독립표본 t검정을 수행하고,
# 평균 차이(A − B)의 95% 신뢰구간(하한, 상한)을 구하시오.
# (각각 소수 넷째 자리에서 반올림하여 셋째 자리까지)

a = df.loc[df['group'] == 'A', 'post_score']
b = df.loc[df['group'] == 'B', 'post_score']

from scipy import stats
result = stats.ttest_ind(a, b, equal_var=True)
ci = result.confidence_interval(confidence_level=0.95)
l = round(ci.low, 3)
h = round(ci.high, 3)
print(l, h)