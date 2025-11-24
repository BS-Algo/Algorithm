import pandas as pd

# 1. 데이터 로드
df = pd.read_csv('simulated_data.csv')

# 2. 결측치 제거
# df.isnull().sum()
df_dropna = df.dropna()
# df_dropna.isnull().sum()

# 3. 유일한 문자형 컬럼인 region의 빈칸 제거
df_dropna_dropna = df_dropna.loc[df['region'] != '', ]
df_dropna_dropna

# 4. 첫 번째 행부터 순서대로 80% 데이터 추출
df_dropna_dropna_80 = df_dropna_dropna.iloc[ : int(len(df_dropna_dropna) * 0.8), : ]
df_dropna_dropna_80

# 5. 'average_income' 변수 3분위수 산출
answer = round(df_dropna_dropna_80['average_income'].quantile(0.75), 2)

# 6. 결과 출력
print(answer)