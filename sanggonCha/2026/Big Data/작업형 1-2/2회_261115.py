#답:
#1. 데이터 불러오기
df = pd.read_csv("users.csv")

#문제

# 주어진 데이터셋(users.csv)의 앞에서부터 순서대로 75% 데이터만 활용해
# 'feature' 컬럼 결측치를 최빈값으로 채우고, 채우기 전 후의 표준편차를 각각 구해서
# 두 표준편차의 차이를 절대값으로 구하시오
df_75 = df.head(int(len(df) * 0.75))
before_std = df_75['feature'].std(ddof=1)

mode_value = df_75['feature'].mode()[0]
df_75['feature'] = df_75['feature'].fillna(mode_value)
# df_75.isnull().sum()

# (단, 표본 표준편차 기준, 두 표준편차 차이는 절대값으로 계산)
after_std = df_75['feature'].std(ddof=1)
diff = abs(before_std - after_std)
print(diff)