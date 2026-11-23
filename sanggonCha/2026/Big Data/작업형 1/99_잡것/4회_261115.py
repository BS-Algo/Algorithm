import pandas as pd

# 1. CSV 파일 로드
df = pd.read_csv('employee_feedback.csv')

# employee_feedback.csv 파일에는 positive_feedback과 neutral_feedback과 negative_feedback 이 있습니다.
# 각 feedback_id 별로 긍정,중립,부정 피드백의 토탈값에 대한 긍정+중립 피드백의 비율을 구하고 그 비율이
# 0.4보다 크고 0.5보다 작으면서, feedback_type 컬럼이 'survey'인 데이터의 개수를 구하세요.
df['pn'] = df['positive_feedback'] + df['neutral_feedback']
df['total'] = df['positive_feedback'] + df['neutral_feedback'] + df['negative_feedback']
df['ratio'] = df['pn'] / df['total']

con1 = (df['ratio'] > 0.4) & (df['ratio'] < 0.5)
con2 = df['feedback_type'] == 'survey'
df2 = df.loc[con1 & con2, : ]

ans = len(df2)
print(ans)