import pandas as pd

# 1. 데이터 로드
df = pd.read_csv('simulated_data.csv')

# 2. 결측치 제거
df.isnull().sum()
df = df.dropna()
df.isnull().sum()

# 3. 유일한 문자형 컬럼인 region의 빈칸 제거
df2 = df.loc[df['region'] != '', : ]

# 4. 첫 번째 행부터 순서대로 80% 데이터 추출
df3 = df2.head(int(0.8 * len(df2)))

# 5. 'average_income' 변수 3분위수 산출
q3 = df3['average_income'].quantile(0.75)

# 6. 결과 출력
ans = round(q3, 2)
print(ans)