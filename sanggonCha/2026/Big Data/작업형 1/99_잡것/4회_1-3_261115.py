import pandas  as  pd

#1. 데이터 불러오기
df = pd.read_csv("employee_data.csv")

# 문제:

# employee_data.csv 파일에서 date_hired가 2020년 1월 1일 이후에 입사했으며, country가 'United States'인
# 직원의 수를 구하세요.
df['date_hired'] = pd.to_datetime(df['date_hired'])
con1 = df['date_hired'] >= '2020-01-01'
con2 = df['country'] == 'United States'
ans = len(df.loc[con1 & con2, :])
print(ans)