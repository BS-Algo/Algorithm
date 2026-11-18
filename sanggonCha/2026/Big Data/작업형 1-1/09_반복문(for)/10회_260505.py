import pandas as pd

df = pd.read_csv('education_data.csv')
df.head(20)

#작업 1) 매출 기여도 분석

# 1.소주제별 정답률을 기준으로 상위 2개 소주제를 선정하시오
# df['소주제'].unique() # array(['대수학', '기하학', '통계학', '미적분', '물리', '화학', '생물', '지구과학', '문법', '독해', '작문', '회화', '문학', '고전'], dtype=object)
소주제별_정답수 = df.groupby('소주제')['정답여부'].sum()
소주제별_정답수

소주제별_응시횟수 = df.groupby('소주제')['학생id'].count()
소주제별_응시횟수

정답률 = 소주제별_정답수 / 소주제별_응시횟수
정렬된_정답률 = 정답률.sort_values(ascending=False)
정렬된_정답률.head(2)

# 2. 해당 2개 소주제에서 발생한 총 매출액을 계산하시오
result = df.loc[ df['소주제'].isin(['문법', '독해']) , '매출액'].sum()
print(result)


# 작업 2) 정답률 3위 값 구하기

# 1.소주제별 정답률을 내림차순으로 정렬했을 때, 3번째로 높은 정답률 값을 구하시오
정답횟수 = df.groupby('소주제')['정답여부'].sum()
정답횟수

응시횟수 = df.groupby('소주제')['학생id'].count()
응시횟수

정답률 = 정답횟수 / 응시횟수
정답률

정답률.sort_values(ascending=False)
정답률

a = sorted(정답률.unique(), reverse=True)
result = a[2]

# 2.최종 답안은 소수점 셋째 자리까지 반올림하여 제출
print(round(result, 3))
