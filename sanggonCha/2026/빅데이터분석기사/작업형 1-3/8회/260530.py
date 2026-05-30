import pandas as pd
import numpy as np

# 가상 기후 데이터 생성
np.random.seed(42)
data = {
    '온도': np.random.uniform(-10, 40, 50),  # '온도' 열에 -10에서 40 사이의 랜덤 값 생성 (섭씨 온도)
    '습도': np.random.uniform(10, 90, 50)   # '습도' 열에 10에서 90 사이의 랜덤 값 생성 (%)
}
df = pd.DataFrame(data)

# 데이터 확인
df

# 1. '온도'와 '습도' 열을 각각 Min-Max 스케일링하세요.
from sklearn.preprocessing import MinMaxScaler

scaler = MinMaxScaler()
df[['온도', '습도']] = scaler.fit_transform(df[['온도', '습도']])
df
# 2. 스케일링된 '온도'와 '습도' 열의 표준편차를 각각 구하세요.
std_tem = df['온도'].std()
std_hum = df['습도'].std()

# 3. '온도' 열의 표준편차에서 '습도' 열의 표준편차를 뺀 값을 소수점 2자리로 반올림하여 구하세요.
diff = std_tem - std_hum
a = round(diff, 2)
print(a)