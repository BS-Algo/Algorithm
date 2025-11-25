import pandas as pd

# 1. CSV 파일 로드
df = pd.read_csv('employee_feedback.csv')


# employee_feedback.csv 파일에는 positive_feedback과 neutral_feedback과 negative_feedback 이 있습니다.
# 각 feedback_id 별로 긍정,중립,부정 피드백의 토탈값에 대한 긍정+중립 피드백의 비율을 구하고 그 비율이
df['긍정+중립'] = df['positive_feedback'] + df['neutral_feedback']
df['total'] = df['긍정+중립'] + df['negative_feedback']
df['비율'] = df['긍정+중립'] / df['total']

# 0.4보다 크고 0.5보다 작으면서, feedback_type 컬럼이 'survey'인 데이터의 개수를 구하세요.
answer = len(df.loc[(df['비율'] > 0.4) & (df['비율'] < 0.5) & (df['feedback_type'] == 'survey'), :])
print(answer)
