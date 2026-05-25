# 📌 시나리오
# 사내 보안팀에서 스팸 메일 필터링 시스템을 고도화하기 위해 기존 메일 데이터를 분석 중입니다. 
# 보안 전문가는 "스팸 메일은 일반 메일보다 단어 수가 현저히 다르다"는 가설을 세웠고, 
# 이를 검증하기 위해 단어 수 차이를 계산해 달라고 요청했습니다. 
# 메일의 본문을 텍스트 마이닝 해서 스팸메일의 단어수-햄메일의 단어수를 출력하세요

# 📊 분석 요구사항
# 각 메일 본문(content)을 띄어쓰기 기준으로 분리하여 포함된 단어의 개수를 세고 다음을 수행하시오.
# 작업 1) label이 'spam'인 메일들의 단어 수를 모두 더하시오
# 작업 2) label이 'ham'인 메일들의 단어 수를 모두 더하시오
# 작업 3) (spam 메일 총 단어 수) - (ham 메일 총 단어 수)의 결과를 제출하시오

import pandas as pd

# 데이터 불러오기
df = pd.read_csv('email_data.csv', encoding='utf-8-sig')
df

# 각 메일 본문(content)을 띄어쓰기 기준으로 분리하여 포함된 단어의 개수를 세고
df['word_count'] = df['content'].str.split().str.len()

# 작업 1) label이 'spam'인 메일들의 단어 수를 모두 더하시오
spam_cnt = df.loc[df['label'] == 'spam', 'word_count']
spam_sum = spam_cnt.sum()

# 작업 2) label이 'ham'인 메일들의 단어 수를 모두 더하시오
ham_cnt = df.loc[df['label'] == 'ham', 'word_count']
ham_sum = ham_cnt.sum()


# 작업 3) (spam 메일 총 단어 수) - (ham 메일 총 단어 수)의 결과를 제출하시오
answer = spam_sum - ham_sum
print(answer)
