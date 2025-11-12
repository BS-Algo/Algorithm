# 답:

#1. 데이터 불러오기

import pandas  as  pd

df = pd.read_csv("subscribers.csv")
#df

#2. clicks 컬럼의 상위 12번째 값을 검색한다.

# df.loc[ 검색조건, 컬럼 ]

a = df.loc[ : , 'clicks'].sort_values(ascending=False).head(12)
b = a.iloc[-1]
b
#3. clicks 컬럼의 상위 12번째까지의 값들을 상위12번째의 값으로 변경한다.
df.loc[ df.loc[ : , 'clicks'].sort_values(ascending=False).head(12).index, 'clicks'] = b

#4. years_subscribed 컬럼에서 5년 이상인 데이터의 'clicks' 컬럼 평균값을 구한다.
result = df.loc[ df['years_subscribed'] >= 5, 'clicks'].mean()

#5. 소수점 3번째자리에서 반올림해서 결과를 출력
print(round(result,3))
