#답:
#1. 데이터 불러오기
df = pd.read_csv("users.csv")
#df.isnull().sum()

#2. 데이터셋 앞에서부터 75% 데이터만 선택하기
df2 = df.head(int(len(df) * 0.75))

#3. 'feature' 컬럼의 결측치 처리전 표준편차 값 구하기 (표본)
before_std = df2['feature'].std(ddof=1)

#4. 'feature' 컬럼의 최빈값을 구합니다.
df2_feature_mode_df = df2['feature'].mode()
df2_feature_mode = df2_feature_mode_df.iloc[0]

#5. 'feature' 컬럼의 결측치를 최빈값으로 채웁니다.
after_fill_feature = df2['feature'].fillna(df2_feature_mode)

#6. 'feature' 컬럼의 결측치 처리후 표준편차 값 구하기
after_std = after_fill_feature.std(ddof=1)

#7. 두 표준편차의 차이의 절대값 계산하기
diff = abs(after_std-before_std)
print(diff)