import pandas as pd

# 1. 데이터 로드
df = pd.read_csv('simulated_data.csv')
# df.shape # (25000, 10)
# df.info()

# 2. 결측치 제거
# df.isnull().sum() # region	5027
df2 = df.dropna()
df2.isnull().sum() # region	0

# 3. 유일한 문자형 컬럼인 region의 빈칸 제거
# df2.loc[df.region == '', : ] # region 열의 값이 빈 문자열("")인 행을 찾음
                               # df.loc[ ... , : ]	조건에 맞는 행 전부, 그리고 모든 열(:) 선택
df3 = df2.loc[df.region != '', : ]
df3
                            
# 4. 첫 번째 행부터 순서대로 80% 데이터 추출
int(len(df3) * 0.8) # 15471
df4 = df3.iloc[0:int(len(df3) * 0.8), : ]

# 5. 'average_income' 변수 3분위수 산출
result = df4['average_income'].quantile(0.75)

# 6. 결과 출력
print(round(result, 2)) # 92842.43