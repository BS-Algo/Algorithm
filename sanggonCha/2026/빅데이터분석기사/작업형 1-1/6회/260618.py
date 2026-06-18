#문제:

# 주어진 delivery_data.csv 파일에는 배달 출발 시간과 도착 시간, 그리고 배달 센터 정보가 포함되어 있습니다.
# 이 데이터를 이용하여 각 배달의 소요 시간을 분 단위로 계산하고, 각 배달센터별 배달 평균 소요 시간을 구하세요.
# 그리고 그 평균 소요시간이 가장 오래 걸린 배달센터의 평균 소요 시간을 정수로 반올림하여 출력하세요.


import pandas as pd

# 1.CSV 파일에서 데이터 로드
df = pd.read_csv('delivery_data.csv')

# object 를 datetime 으로 변환
df['출발시간'] = pd.to_datetime(df['출발시간'])
df['도착시간'] = pd.to_datetime(df['도착시간'])

# 이 데이터를 이용하여 각 배달의 소요 시간을 분 단위로 계산하고
df['소요시간'] = df['도착시간'] - df['출발시간']
df['소요시간'] = df['소요시간'].dt.total_seconds() / 60 # seconds / 60 = minutes

# 각 배달센터별 배달 평균 소요 시간을 구하세요.
df2 = df.groupby('배달센터')['소요시간'].mean()

# 그리고 그 평균 소요시간이 가장 오래 걸린 배달센터의 평균 소요 시간을 구하시오
m = df2.max()
# 평균 소요 시간을 정수로 반올림하여 출력하세요.
ans = round(m)
print(ans)