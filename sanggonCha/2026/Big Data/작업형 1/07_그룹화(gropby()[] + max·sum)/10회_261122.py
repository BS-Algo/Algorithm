import pandas as pd

df = pd.read_csv('education_data.csv')

#작업 1) 매출 기여도 분석

# 1.소주제별 정답률을 기준으로 상위 2개 소주제를 선정하시오
# 📝 제1유형.문제1

# 작업 1) 매출 기여도 분석
# 1.소주제별 정답률을 기준으로 상위 2개 소주제를 선정하시오

df_j = df.groupby('소주제')['정답여부'].sum() # 정답 횟수
df_p = df.groupby('소주제')['학생id'].count() # 푼 횟수
df_정답률 = df_j / df_p
s_index = df_정답률.sort_values(ascending=False).head(2).index

# 2.해당 2개 소주제에서 발생한 총 매출액을 계산하시오
ans = 0
for juje in s_index:
  ans += df.loc[df['소주제'] == juje, '매출액'].sum()
print(ans)

# 1. 소주제별 정답률을 내림차순으로 정렬했을 때, 3번째로 높은 정답률 값을 구하시오
ans2 = df_정답률.sort_values(ascending=False).head(3)[-1]
ans2 = df_정답률.sort_values(ascending=False).head(3)[-1]
# 2. 최종 답안은 소수점 셋째 자리까지 반올림하여 제출
print(round(ans2, 3))