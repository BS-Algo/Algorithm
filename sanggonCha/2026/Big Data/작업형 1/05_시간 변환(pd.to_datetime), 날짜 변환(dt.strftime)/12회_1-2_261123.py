# 출력을 원하실 경우 print() 함수를 사용하세요.
# 코드는 수정 가능하며, 최종 결과만 print 하세요.
import pandas as pd

# 데이터 읽기
df = pd.read_csv("lecture.csv")
df.head(30)

# 작업형 1-2 (배점 5점)
# 📌 시나리오
# lecture.csv 에서 아래 조건을 모두 만족하는 강의가 몇 개인지 구하시오.
# 📌 풀이 조건
# 1. 개설일이 2025년 7월 1일부터 2025년 12월 31일까지 이다. (시작일과 마지막 날 포함)
# 2. 수강인원(students)이 30명 이상 이다. (30명 포함)
df['open_date'] = pd.to_datetime(df['open_date'])
c1 = df['open_date'] >= '2025-07-01'
c2 = df['open_date'] <= '2025-12-31'
c3 = df['students'] >= 30
ans = len(df.loc[c1 & c2 & c3, : ])
print(ans)