# 문제3.기후 데이터 분석

# 주어진 기후 데이터에서 다음 작업을 수행하세요.
# 1. '온도'와 '습도' 열을 각각 Min-Max 스케일링하세요.
# 2. 스케일링된 '온도'와 '습도' 열의 표준편차를 각각 구하세요.
# 3. '온도' 열의 표준편차에서 '습도' 열의 표준편차를 뺀 값을 소수점 2자리로 반올림하여 구하세요.
from sklearn.preprocessing import MinMaxScaler
scaler = MinMaxScaler()
df2 = df.copy()
df2[['온도', '습도']] = scaler.fit_transform(df[['온도', '습도']])
std_t = df2['온도'].std()
std_h = df2['습도'].std()
diff = std_t - std_h
ans = round(diff, 2)
print(ans)