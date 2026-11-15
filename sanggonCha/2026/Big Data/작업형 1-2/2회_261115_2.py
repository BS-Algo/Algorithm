#문제

#답:
#1. 데이터 불러오기
df = pd.read_csv("users.csv")

# 주어진 데이터셋(users.csv)의 앞에서부터 순서대로 75% 데이터만 활용해
# 'feature' 컬럼 결측치를 최빈값으로 채우고, 채우기 전 후의 표준편차를 각각 구해서
# 두 표준편차의 차이를 절대값으로 구하시오

# (단, 표본 표준편차 기준, 두 표준편차 차이는 절대값으로 계산)

# df.isnull().sum()
df75 = df.iloc[0: round(len(df['feature']) * 0.75), :]
df75_mode_val = df75['feature'].mode()[0]
before_std = df75['feature'].std()
df75['feature'] = df75['feature'].fillna(df75_mode_val)
df75.isnull().sum()
after_std = df75['feature'].std()
diff = abs(before_std - after_std)
print(diff)