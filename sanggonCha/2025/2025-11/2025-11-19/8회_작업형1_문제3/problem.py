#답:

# 1. Min-Max 스케일링
from sklearn.preprocessing import MinMaxScaler

scaler = MinMaxScaler()
df[['온도', '습도']] = scaler.fit_transform(df[['온도', '습도']])
df

# 2. 표준편차 계산
std_temp = df['온도'].std()
std_hum = df['습도'].std()

# 3. 표준편차 차이 계산 및 소수점 2번째 자리에서 반올림
diff = std_temp - std_hum
print(round(diff, 2))