import pandas as pd

# 데이터 불러오기
df = pd.read_csv('email_data.csv', encoding='utf-8-sig')
df
# 작업 1) label이 'spam'인 메일들의 단어 수를 모두 더하시오
# 작업 2) label이 'ham'인 메일들의 단어 수를 모두 더하시오
# 작업 3) (spam 메일 총 단어 수) - (ham 메일 총 단어 수)의 결과를 제출하시오
df['count'] = df['content'].str.split().str.len()
s_c = df.loc[df['label'] == 'spam', 'count'].sum()
h_c = df.loc[df['label'] == 'ham', 'count'].sum()
ans = s_c - h_c
print(ans)

# str.split() 의 결과는 리스트 형태로 저장됨.
# 그래서 str.len() 을 사용 가능