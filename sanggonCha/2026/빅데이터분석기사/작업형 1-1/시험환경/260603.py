# 출력을 원할 경우 print() 함수 활용
# 예시) print(df.head())

# getcwd(), chdir() 등 작업 폴더 설정 불필요
# 파일 경로 상 내부 드라이브 경로(C: 등) 접근 불가

import pandas as pd
import math

df = pd.read_csv("data/employee_performance.csv")

# 1. 고객만족도 결측치 처리
고객만족도_평균 = df['고객만족도'].mean()
df['고객만족도'] = df['고객만족도'].fillna(고객만족도_평균)

# 2. 근속연수 결측치 처리
df.dropna(subset=['근속연수'], inplace=True)

# 3. 고객만족도 3사분위수 구하기
고객만족도_3사분위수 = math.floor(df['고객만족도'].quantile(0.75))
print(고객만족도_3사분위수)

# 4-1. 부서별 평균연봉 구하기
부서별_평균연봉 = df.groupby('부서')['연봉'].mean()

# 4-2. 두 번째로 높은 평균연봉 구하기
부서별_평균연봉_내림차순 = 부서별_평균연봉.sort_values(ascending=False)
두_번쨰로_높은_부서별_평균연봉 = math.floor(부서별_평균연봉_내림차순.iloc[1])
print(두_번쨰로_높은_부서별_평균연봉)