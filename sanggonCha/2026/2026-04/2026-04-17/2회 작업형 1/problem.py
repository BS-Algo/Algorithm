# 2회_작업형1_문제1_데이터 생성하기

import pandas as pd
import numpy as np

# 가상 데이터 생성
np.random.seed(0)
data = {
    'user_id': np.arange(1, 201),
    'years_subscribed': np.random.randint(1, 11, 200),
    'clicks': np.random.randint(10, 500, 200)
}

# DataFrame 생성
df = pd.DataFrame(data)

# CSV 파일로 저장
df.to_csv("subscribers.csv", index=False)

#문제

# 주어진 데이터셋(subscribers.csv)의 'clicks' 컬럼에서 상위 12개 데이터의 값들을 상위
# 12번째 값으로 대체한 후, years_subscribed 컬럼에서 5년 이상인 데이터의 'clicks' 컬럼
# 평균값을 구하세요. 소수점 3번째자리에서 반올림해서 결과를 출력해서 제출하세요.

# 답:

#1. 데이터 불러오기

import pandas  as  pd

df = pd.read_csv("subscribers.csv")


#2. clicks 컬럼의 상위 12번째 값을 검색한다.
# df.loc[ 검색조건, 컬럼 ]
# df - df는 데이터 프레임(2차원 상태)
# df.loc[ : , 'clicks'] - 이렇게 하면 한 컬럼만 쭉 뽑아내기 때문에 df -> series 상태가 됨
# 인덱스는 가상의 컬럼으로 존재하는 상태
# 인덱스는 가상의 컬럼이지만, 실제로 모든 df(데이터 프레임)에 존재함.
# 지정 안 해도 자동 생성됨!
head_12_series = df.loc[ : , 'clicks'].sort_values(ascending=False).head(12)
head_12_series # 상위 12개의 값 확인
head_12 = head_12_series.iloc[-1]
head_12 # 상위 12번 째 값 확인

# loc vs iloc
# loc: (label) location
# iloc: integer location


#3. clicks 컬럼의 상위 12번째까지의 값들을 상위12번째의 값으로 변경한다.
df.loc[head_12_series.index, 'clicks'] = head_12
df.loc[ : , 'clicks'].sort_values(ascending=False).head(12) # 상위 12개의 값 확인

#4. years_subscribed 컬럼에서 5년 이상인 데이터의 'clicks' 컬럼 평균값을 구한다.
# df['years_subscribed'] - 이렇게 쓰면 컬럼을 기준으로 탐색. + 여러 컬럼을 쓰면 당연히 여러 컬럼 검색
# df['years_subscribed'] 이렇게 쓰면 'years_subscribed' 컬럼 series 가 반환됨
# df['years_subscribed'] > 5 를 하면 boolean series 가 반환됨
# df.loc[a, b]의 a와 b에는 데이터를 가져올 조건이 각각 들어가야함
# 그래서 boolean series가 들어가는 것이 타당함

bef_ans = df.loc[ df['years_subscribed'] > 5, 'clicks'].mean()
bef_ans

# 만약 " 'years_subscribed' > 5 "가 들어간다면, 문자열과 숫자의 비교라서 안 됨!

#5. 소수점 3번째자리에서 반올림해서 결과를 출력
answer = round(bef_ans, 3)
print(answer) # 출력하라고 했으면 print문을 찍어야함