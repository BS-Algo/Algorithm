#답:
#1. 데이터 불러오기
df = pd.read_csv("users.csv")
# df.isnull().sum()

#2. 데이터셋 앞에서부터 75% 데이터만 선택하기
df_75 = df.iloc[ 0: int(len(df) * 0.75), : ]

#3. 'feature' 컬럼의 결측치 처리전 표준편차 값 구하기 (표본)
std_before = df_75['feature'].std(ddof=1)

#4. 'feature' 컬럼의 최빈값을 구합니다.
df_mode = df_75['feature'].mode()[0]

#5. 'feature' 컬럼의 결측치를 최빈값으로 채웁니다.
afterFill_df_75 = df_75['feature'].fillna(df_mode)
# df_75.isnull().sum() # 14 
# afterFill_df_75.isnull().sum() # 0

#6. 'feature' 컬럼의 결측치 처리후 표준편차 값 구하기
std_after = afterFill_df_75.std(ddof=1)

#7. 두 표준편차의 차이의 절대값 계산하기
print(abs(std_before - std_after))