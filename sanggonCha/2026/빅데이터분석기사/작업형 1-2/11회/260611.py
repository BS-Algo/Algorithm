# 출력을 원하실 경우 print() 함수를 사용하세요.
# 코드는 수정 가능하며, 최종 결과만 print 하세요.
import pandas as pd

# 1. 데이터 읽기
df = pd.read_csv("data_q1_2.csv")
df.head(20)

# 2. 결측치가 가장 많은 컬럼 찾기
df.isnull().sum()

# 3. 중앙값(Median) 계산 (결측치 제외하고 계산됨)
humidity_mean = df['Humidity'].mean()

# 4. 결측치 대치 (fillna)
df['Humidity'] = df['Humidity'].fillna(humidity_mean)
df.isnull().sum()

# 5. 평균(Mean) 계산
humidity_mean = df['Humidity'].mean()
humidity_mean

# 6. 결과 출력 (소수점 둘째 자리 반올림)
ans = round(humidity_mean, 2)
print(ans)