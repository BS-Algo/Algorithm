# 출력을 원하실 경우 print() 함수를 사용하세요.
# 코드는 수정 가능하며, 최종 결과만 print 하세요.
import pandas as pd

# 데이터 읽기
df = pd.read_csv("exam_score.csv")
df.head(10)

# 작업형 1-3 (배점 5점)
# 📌 시나리오
# exam_score.csv 에서 아래 순서대로 계산하여 전체 교육생의 평균 점수 를 구하시오.
 

# 📌 풀이 조건과 주의사항
# 1. score의 결측치를 그 교육생이 속한 반(class)의 중앙값(Median) 으로 채운다.
# (예: B반 교육생의 점수가 비어 있으면, B반에서 점수가 있는 교육생들의 중앙값으로 채운다.)
# 2. 결측치를 채운 데이터에서 240명 전체의 score 평균(Mean) 을 구한다.
# - 답안 형식: 소수 셋째 자리에서 반올림하여 둘째 자리까지 (예: 71.456 -> 71.46)
# df.isnull().sum()
m = df.groupby('class')['score'].transform('median')
df['score'] = df['score'].fillna(m)
# df.isnull().sum()
score_mean = round(df['score'].mean(), 2)
print(score_mean)

# 작업형 1-4 (배점 5점)
# 📌 시나리오
# exam_score.csv 에서 작업형 1-3과 같이 결측치를 채운 데이터 를 그대로 사용하여 A반과 B반의 합동분산 을 구하시오.
dfA = df.loc[df['class'] == 'A', 'score']
lenA = len(dfA)
varA = dfA.var()

dfB = df.loc[df['class'] == 'B', 'score']
lenB = len(dfB)
varB = dfB.var()

# 합동 분산
ans = round((((lenA - 1) * varA) + ((lenB - 1) * varB)) / (lenA + lenB - 2), 2)
print(ans)