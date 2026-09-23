# 문제:

# employee_feedback.csv 파일에는 positive_feedback과 neutral_feedback과 negative_feedback 이 있습니다.
# 각 feedback_id 별로 긍정,중립,부정 피드백의 토탈값에 대한 긍정+중립 피드백의 비율을 구하고 그 비율이
# 0.4보다 크고 0.5보다 작으면서, feedback_type 컬럼이 'survey'인 데이터의 개수를 구하세요.

# 이 데이터는 직원 피드백 데이터를 나타내며,

# feedback_id: 각 피드백 항목의 고유 식별자입니다. 1부터 시작하여 데이터가 추가될 때마다 증가합니다.
# feedback_type: 피드백의 유형을 나타내며, survey (설문조사), review (리뷰), comment (댓글)로 구분됩니다.
# positive_feedback: 긍정적인 피드백의 수치입니다. 예를 들어, 칭찬이나 긍정적인 코멘트의 횟수를 나타낼 수 있습니다.
# neutral_feedback: 중립적인 피드백의 수치입니다. 예를 들어, 정보 제공이나 중립적인 코멘트를 나타낼 수 있습니다.
# negative_feedback: 부정적인 피드백의 수치입니다. 예를 들어, 불만이나 비판적인 코멘트의 횟수를 나타낼 수 있습니다.

import pandas as pd

# 1. CSV 파일 로드
df = pd.read_csv('employee_feedback.csv')

# 2. feedback_id 별로 긍정,중립,부정 피드백의 토탈값 구하기
df['total'] = df['positive_feedback'] + df['neutral_feedback'] + df['negative_feedback']

# 3. 토탈값에 대한 긍정+중립 피드백의 비율을 구하기
df['ratio'] = (df['positive_feedback'] + df['neutral_feedback']) / df['total']

# 4. 그 비율이  0.4보다 크고 0.5보다 작으면서, feedback_type 컬럼이 'survey'인 데이터의 개수 구하기
ans = len(df.loc[(df['ratio'] > 0.4) & (df['ratio'] < 0.5) & (df['feedback_type'] == 'survey'), : ])
print(ans)