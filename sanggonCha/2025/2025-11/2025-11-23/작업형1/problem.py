# 출력을 원할 경우 print() 함수 활용
# 예시) print(df.head())

# getcwd(), chdir() 등 작업 폴더 설정 불필요
# 파일 경로 상 내부 드라이브 경로(C: 등) 접근 불가

import pandas as pd

df = pd.read_csv("data/employee_performance.csv")
#print(df.head(5))
#print(df.info())

# 사용자 코딩

# 1. 고객만족도 없는 직원 구하기 -> 평균 고객 만족도 구하기 -> 구한 평균 고객만족도로 결측치 채우기
#print(df['고객만족도'].isnull().sum())
df['고객만족도'] = df['고객만족도'].fillna(df['고객만족도'].mean())
#print(df['고객만족도'].isnull().sum())

# 4. 근속연수가 없는 직원 삭제
df = df.dropna(subset=['근속연수'])
#print(df['근속연수'].isnull().sum())

# 5. 직원의 고객만족도의 3사분위수 값 구하기
import math
answer1 = math.floor(df['고객만족도'].quantile(0.75))
print(answer1)
#print(q3)

# 6. 부서별로 평균 연봉 구하기
avg = df.groupby('부서')['연봉'].mean()

# 7. 두 번째로 높은 평균연봉 구하기
answer2 = math.floor(avg.sort_values(ascending=False).iloc[1])
print(answer2)

# 해당 화면에서는 제출하지 않으며, 문제 풀이 후 답안제출에서 결괏값 제출