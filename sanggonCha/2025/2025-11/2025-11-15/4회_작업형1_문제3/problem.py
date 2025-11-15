import pandas  as  pd

#1. 데이터 불러오기
df = pd.read_csv("employee_data.csv")
# df

#2. date_hired 를 날짜형 변환
# date.info()
df['date_hired'] = pd.to_datetime(df['date_hired'])
# df.info()

#3. date_hired가 2020년 1월 1일 이후에 입사했으며, country가 'United States'인  직원수 출력
filtered = df.loc[ (df['date_hired'] > '2020-01-01') & (df['country'] == 'United States'), : ]
print(len(filtered))