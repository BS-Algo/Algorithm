# 2회_작업형1_문제1

# 답:

#1. 데이터 불러오기

import pandas  as  pd

df = pd.read_csv("subscribers.csv")
#문제

# 주어진 데이터셋(subscribers.csv)의 'clicks' 컬럼에서 상위 12개 데이터의 값들을 상위
# 12번째 값으로 대체한 후, years_subscribed 컬럼에서 5년 이상인 데이터의 'clicks' 컬럼
# 평균값을 구하세요. 소수점 3번째자리에서 반올림해서 결과를 출력해서 제출하세요.

df2 = df['clicks'].sort_values(ascending=False).iloc[:12]
val12 = df2.iloc[-1]
i = df2.index

df.loc[i, 'clicks'] = val12
df3 = round(df.loc[df['years_subscribed'] >= 5, 'clicks'].mean(), 2)
print(df3)