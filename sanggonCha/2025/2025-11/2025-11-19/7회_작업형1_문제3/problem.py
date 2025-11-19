# 답안:

#1. 데이터 확인
df = pd.DataFrame(pm10_data, columns=['pm10'])
df.head()

# 2. IQR 계산
q1 = df['pm10'].quantile(0.25)
q3 = df['pm10'].quantile(0.75)

# 3. 하한선(Lower bound)과 상한선(Upper bound) 계산
iqr = q3 - q1
lower_bound = q1 - 1.5 * iqr
upper_bound = q3 + 1.5 * iqr

# 4. 이상치 탐지
outliers = df.loc[ (df['pm10'] < lower_bound ) | ( df['pm10'] > upper_bound ), : ]
print(len(outliers))