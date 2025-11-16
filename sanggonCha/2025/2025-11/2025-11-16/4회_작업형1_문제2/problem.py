import pandas as pd

# 1. CSV 파일 로드
df = pd.read_csv('employee_feedback.csv')
df

# 2. feedback_id 별로 긍정,중립,부정 피드백의 토탈값 구하기
# 컬럼을 새로 만들어야 하나? -> yes
df['total'] = df['positive_feedback'] + df['neutral_feedback'] + df['negative_feedback'] # 이렇게만 해도 컬럼이 만들어진다!
df

# 3. 토탈값에 대한 긍정+중립 피드백의 비율을 구하기
df['ratio'] = (df['positive_feedback'] + df['neutral_feedback']) / df['total']
df

# 4. 그 비율이  0.4보다 크고 0.5보다 작으면서, feedback_type 컬럼이 'survey'인 데이터의 개수 구하기
# df.loc[행, 열]
filtered = df.loc[ (df['ratio'] > 0.4) & (df['ratio'] < 0.5) & (df['feedback_type'] == 'survey'), : ]
print(len(filtered))