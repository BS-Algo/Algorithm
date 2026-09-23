#문제

# 주어진 데이터셋(subscribers.csv)의 'clicks' 컬럼에서 상위 12개 데이터의 값들을 상위
# 12번째 값으로 대체한 후, years_subscribed 컬럼에서 5년 이상인 데이터의 'clicks' 컬럼
# 평균값을 구하세요. 소수점 3번째자리에서 반올림해서 결과를 출력해서 제출하세요.

# 답:

#1. 데이터 불러오기

import pandas  as  pd

df = pd.read_csv("subscribers.csv")


#2. clicks 컬럼의 상위 12번째 값을 검색한다.
df2 = df.sort_values(by='clicks', ascending=False).head(12)
num12 = df2['clicks'].iloc[-1]

#3. clicks 컬럼의 상위 12번째까지의 값들을 상위12번째의 값으로 변경한다.
df.loc[df.loc[ : , 'clicks'].sort_values(ascending=False).head(12).index, 'clicks'] = num12

#4. years_subscribed 컬럼에서 5년 이상인 데이터의 'clicks' 컬럼 평균값을 구한다.
a = df.loc[df['years_subscribed'] >= 5, 'clicks'].mean()

#5. 소수점 3번째자리에서 반올림해서 결과를 출력
ans = round(a, 2)
print(ans)