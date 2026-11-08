# #문제

# 주어진 데이터셋(simulated_data.csv)의 결측값을 제거한 후,
# 데이터를 처음부터 순서대로 80%를 추출하여 average_income 변수의 3분위수를 산출하세요.
# 결과는 소수점 2번째 자리까지 출력하세요 !

# 👉 풀이 주의사항:

# 데이터셋의 유일한 문자형 컬럼인 region의 빈칸 '' 인 데이터가 존재할 수 있으므로,
# 이를 결측으로 처리하고 제거해야 합니다.

import pandas as pd

# 1. 데이터 로드
df = pd.read_csv('simulated_data.csv')
df.shape # (25000, 10): 데이터의 크기
# df.info() # 컬럼들의 정보

# 2. 결측치 제거
df.isnull().sum()
df2 = df.dropna()
df2.isnull().sum()

# 3. 유일한 문자형 컬럼인 region의 빈칸 제거
df3 = df2.loc[df['region'] != '', : ]
df3.shape # (19339, 10)
df3.isnull().sum()

# 4. 첫 번째 행부터 순서대로 80% 데이터 추출
len(df3) * 0.8 # 19339
df4 = df3.iloc[0: int(len(df3) * 0.8), : ] # 15471
df4

# 5. 'average_income' 변수 3분위수 산출
result = df4['average_income'].quantile(0.75)

# 6. 결과 출력
print(round(result,2 ))