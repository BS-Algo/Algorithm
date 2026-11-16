#문제3. pm10(미세먼지)의 이상치를 찾아보세요. 이를 위해 사분위수 범위(IQR)를 사용해
#       상한과 하한을 계산하고, 이상치로 간주되는 값을 도출하세요.

# 1. pm10 데이터에서 제 1사분위수(Q1)와 제 3사분위수(Q3)를 구하세요.

# 2. 사분위수 범위(IQR)는 Q3에서 Q1을 뺀 값으로 정의됩니다. IQR을 계산하세요.

# 3. 하한값(Lower bound)과 상한값(Upper bound)은 각각 Q1에서 1.5배 IQR을 뺀 값,
#    Q3에서 1.5배 IQR을 더한 값으로 계산됩니다. 이를 통해 상한과 하한을 구하세요.

# 4. pm10 값이 상한을 초과하거나 하한 미만인 값을 이상치로 간주하고, 그 수를 구하세요.


# 답안:

#1. 데이터 확인
df = pd.DataFrame(pm10_data, columns=['pm10'])
q1 = df['pm10'].quantile(0.25)
q3 = df['pm10'].quantile(0.75)

iqr = q3 - q1

lower = q1 - 1.5 * iqr
upper = q3 + 1.5 * iqr

ans = len(df.loc[(df['pm10'] > upper) | (df['pm10'] < lower), 'pm10'])
print(ans)
