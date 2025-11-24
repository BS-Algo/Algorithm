#답:
#1. 데이터 불러오기
df = pd.read_csv("users.csv")
#df.isnull().sum()

#2. 데이터셋 앞에서부터 75% 데이터만 선택하기
df_75 = df.head(int(len(df) * 0.75)).copy()
#df_75 = df.iloc[0:int(len(df) * 0.75), : ].copy()


#3. 'feature' 컬럼의 결측치 처리전 표준편차 값 구하기 (표본)
before_df_std = df_75['feature'].std(ddof=1)

#4. 'feature' 컬럼의 최빈값을 구합니다.
df_75_mode = df_75['feature'].mode().values[0]
# df_75_mode

#5. 'feature' 컬럼의 결측치를 최빈값으로 채웁니다.
df_75['feature'] = df_75['feature'].fillna(df_75_mode)

#6. 'feature' 컬럼의 결측치 처리후 표준편차 값 구하기
after_df_std = df_75['feature'].std()

#7. 두 표준편차의 차이의 절대값 계산하기
std_diff = abs(before_df_std - after_df_std)

#8. 결과 출력하기
print(std_diff)
