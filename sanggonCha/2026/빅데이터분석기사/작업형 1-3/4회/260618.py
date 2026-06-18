# 문제:

# employee_data.csv 파일에서 date_hired가 2020년 1월 1일 이후에 입사했으며, country가 'United States'인
# 직원의 수를 구하세요.

import pandas  as  pd

#1. 데이터 불러오기
df = pd.read_csv("employee_data.csv")

#2. date_hired 를 날짜형 변환
df['date_hired'] = pd.to_datetime(df['date_hired'])

#3. date_hired가 2020년 1월 1일 이후에 입사했으며, country가 'United States'인  직원수 출력
ans = len(df.loc[(df['date_hired'] > '20200101') & (df['country'] == 'United States'), ])
print(ans)