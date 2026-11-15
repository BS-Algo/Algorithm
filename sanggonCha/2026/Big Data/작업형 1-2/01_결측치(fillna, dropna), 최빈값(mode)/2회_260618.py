#문제

# 주어진 데이터셋(users.csv)의 앞에서부터 순서대로 75% 데이터만 활용해
# 'feature' 컬럼 결측치를 최빈값으로 채우고, 채우기 전 후의 표준편차를 각각 구해서
# 두 표준편차의 차이를 절대값으로 구하시오

# (단, 표본 표준편차 기준, 두 표준편차 차이는 절대값으로 계산)

#답:
#1. 데이터 불러오기
df = pd.read_csv("users.csv")
#df.isnull().sum()

#2. 데이터셋 앞에서부터 75% 데이터만 선택하기
df2 = df.iloc[ 0 : int(len(df) * 0.75) , : ]

#3. 'feature' 컬럼의 결측치 처리전 표준편차 값 구하기 (표본)
before_std = df2['feature'].std(ddof=1)

#4. 'feature' 컬럼의 최빈값을 구합니다.
feature_mode = df2['feature'].mode()[0]

#5. 'feature' 컬럼의 결측치를 최빈값으로 채웁니다.
df2['feature'] = df2['feature'].fillna(feature_mode)

#6. 'feature' 컬럼의 결측치 처리후 표준편차 값 구하기
after_std = df2['feature'].std(ddof=1)

#7. 두 표준편차의 차이의 절대값 계산하기
diff = abs(before_std - after_std)
print(diff)