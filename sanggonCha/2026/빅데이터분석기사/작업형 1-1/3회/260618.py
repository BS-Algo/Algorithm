#문제

# 주어진 데이터셋(simulated_data.csv)의 결측값을 제거한 후,
# 데이터를 처음부터 순서대로 80%를 추출하여 average_income 변수의 3분위수를 산출하세요.
# 결과는 소수점 2번째 자리까지 출력하세요 !

# 👉 풀이 주의사항:

# 데이터셋의 유일한 문자형 컬럼인 region의 빈칸 '' 인 데이터가 존재할 수 있으므로,
# 이를 결측으로 처리하고 제거해야 합니다.

import pandas as pd

# 1. 데이터 로드
df = pd.read_csv('simulated_data.csv')

# 2. 결측치 제거
df = df.dropna()

# 3. 유일한 문자형 컬럼인 region의 빈칸 제거
df2 = df.loc[df['region'] != '', ]

# 4. 첫 번째 행부터 순서대로 80% 데이터 추출
df3 = df2.iloc[ 0 : int(len(df2) * 0.8), : ]

# 5. 'average_income' 변수 3분위수 산출
q3 = df3['average_income'].quantile(0.75)

# 6. 결과 출력
ans = round(q3, 2)
print(ans)