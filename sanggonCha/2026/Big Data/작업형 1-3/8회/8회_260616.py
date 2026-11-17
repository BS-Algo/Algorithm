import pandas as pd
import numpy as np

# 가상 기후 데이터 생성
np.random.seed(42)
data = {
    '온도': np.random.uniform(-10, 40, 50),  # '온도' 열에 -10에서 40 사이의 랜덤 값 생성 (섭씨 온도)
    '습도': np.random.uniform(10, 90, 50)   # '습도' 열에 10에서 90 사이의 랜덤 값 생성 (%)
}
df = pd.DataFrame(data)

from sklearn.preprocessing import MinMaxScaler

scaler = MinMaxScaler()

df['온도'] = scaler.fit_transform(df[['온도']])
df['습도'] = scaler.fit_transform(df[['습도']])

std_tem = df['온도'].std()
std_hum = df['습도'].std()

diff = std_tem - std_hum
ans = round(diff, 2)
print(ans)