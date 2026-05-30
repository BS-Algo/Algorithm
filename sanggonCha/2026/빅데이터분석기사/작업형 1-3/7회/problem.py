# 문제3. pm10(미세먼지)의 이상치를 찾아보세요. 이를 위해 사분위수 범위(IQR)를 사용해
# 상한과 하한을 계산하고, 이상치로 간주되는 값을 도출하세요.

#1. 데이터 확인
df = pd.DataFrame(pm10_data, columns=['pm10'])

# 사분위수 범위(IQR) 찾기
q1 = df['pm10'].quantile(0.25)
q3 = df['pm10'].quantile(0.75)
iqr = q3 - q1

# # 상한과 하한을 계산하고, 이상치로 간주되는 값을 도출하세요.
upper_bound = q3 + 1.5 * iqr
lower_bound = q1 - 1.5 * iqr

outlier = df.loc[(df['pm10'] < lower_bound) | (df['pm10'] > upper_bound) , : ]
outlier