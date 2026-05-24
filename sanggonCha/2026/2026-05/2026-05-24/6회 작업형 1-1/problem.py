import pandas as pd

# 1.CSV 파일에서 데이터 로드
df = pd.read_csv('delivery_data.csv')

# 주어진 delivery_data.csv 파일에는 배달 출발 시간과 도착 시간, 그리고 배달 센터 정보가 포함되어 있습니다.
# 데이터 타입 확인 - object 면 datetime으로 변환
df['출발시간'] =pd.to_datetime(df['출발시간'])
df['도착시간'] =pd.to_datetime(df['도착시간'])
# df.info()

# 소요시간 계산(도착시간 - 출발시간)
df['소요시간'] = df['도착시간'] - df['출발시간']

# 각 배달의 소요 시간을 분 단위로 계산
# dt.days: 시분초 무시하고,일수 차이만 반환
# dt.seconds: 일수를 무시하고, 시분초 차이만 반환
# dt.total_seconds: 일수시분초 차이를 반환

df['소요시간(분)']= df['소요시간'].dt.total_seconds() / 60


# 각 배달센터별 배달 평균 소요 시간을 구하기
df2 = df.groupby('배달센터')['소요시간(분)'].mean()
df2

# 평균 소요시간이 가장 오래 걸린 배달센터의 평균 소요 시간 구하기
a = df2.max()

# 정수로 반올림하여 출력
b = round(a)
print(b)
