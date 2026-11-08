import pandas  as  pd

#1. 데이터 불러오기
df = pd.read_csv("employee_data.csv")

# 문제:

# employee_data.csv 파일에서 date_hired가 2020년 1월 1일 이후에 입사했으며, 
# df.info() # date_hired: object
df['date_hired'] = pd.to_datetime(df['date_hired'])
# df.info() # date_hired: datetime64[ns]

df.loc[(df['date_hired'] >= '20200101'), :]

# country가 'United States'인
df.loc[(df['date_hired'] >= '20200101') & (df['country'] == 'United States'), :]

# 직원의 수를 구하세요.
cnt = len(df.loc[(df['date_hired'] >= '20200101') & (df['country'] == 'United States'), :])
print(cnt)
