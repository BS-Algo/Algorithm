#답:
#1. 데이터 불러오기
df = pd.read_csv("users.csv")
df.isnull().sum()
#df.isnull().sum()

#2. 데이터셋 앞에서부터 75% 데이터만 선택하기
df_75 = df.iloc[ 0:int(len(df) * 0.75), :].copy()
df_75

#3. 'feature' 컬럼의 결측치 처리전 표준편차 값 구하기 (표본)
before_std = df_75['feature'].std(ddof=1)
before_std

#4. 'feature' 컬럼의 최빈값을 구합니다.
mode_value = df_75['feature'].mode()[0]
mode_value

#5. 'feature' 컬럼의 결측치를 최빈값으로 채웁니다.
df_75['feature'] = df_75['feature'].fillna(mode_value)
df_75['feature'].isnull().sum() # 이제 최빈값이 0개임

#6. 'feature' 컬럼의 결측치 처리후 표준편차 값 구하기
after_std = df_75['feature'].std(ddof=1)
after_std

#7. 두 표준편차의 차이의 절대값 계산하기
print(abs(before_std - after_std))