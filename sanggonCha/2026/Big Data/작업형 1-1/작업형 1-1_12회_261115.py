# str.contains

# 작업형 1-1 (배점 5점)
# 📌 시나리오
# lecture.csv 에서 강의명(lecture_name)에 아래 두 단어 중 하나라도 들어 있는 강의가 몇 개인지 구하시오.
# 📌 풀이 조건과 주의사항
# 1. Python — 영어 대소문자를 구분하지 않는다. Python, python, PYTHON은 모두 같은 단어로 본다.
# 2. 파이썬
# - 단어가 강의명의 앞·중간·끝 어디에 있어도 포함된 것으로 본다.
# - 두 단어가 모두 들어 있는 강의도 1개로 센다.
# - 답안 형식: 정수 (예: 57)

import pandas as pd

# 데이터 읽기
df = pd.read_csv("lecture.csv")
df.head(10)
df
# 1. 강의명(lecture_name)에 'Python'이 들어 있는지 확인한다. (대소문자 구분 없음)
a = df['lecture_name'].str.contains('Python', case=False)

# 2. 강의명(lecture_name)에 '파이썬'이 들어 있는지 확인한다.
b = df['lecture_name'].str.contains('파이썬')

# 3. 두 단어 중 하나라도 들어 있는 강의만 골라낸다. (| 는 '또는')
ans = len(df.loc[ a | b, : ])

# 4. 골라낸 강의가 몇 개인지 출력한다.
print(ans)


# 작업형 1-2 (배점 5점)
# 📌 시나리오
# lecture.csv 에서 아래 조건을 모두 만족하는 강의가 몇 개인지 구하시오.
# 📌 풀이 조건
# 1. 개설일이 2025년 7월 1일부터 2025년 12월 31일까지 이다. (시작일과 마지막 날 포함)
# 2. 수강인원(students)이 30명 이상 이다. (30명 포함)
# 💻제출 형식
# 1.정답은 정수형(int)으로 출력하시오. (예: 57)
# 2.코드 내에 불필요한 print문이 없도록 하시오.

# 출력을 원하실 경우 print() 함수를 사용하세요.
# 코드는 수정 가능하며, 최종 결과만 print 하세요.
import pandas as pd

# 데이터 읽기
df = pd.read_csv("lecture.csv")
df.head(30)

# 1. 개설일이 2025년 7월 1일부터 2025년 12월 31일까지 이다. (시작일과 마지막 날 포함)
df['open_date'] = pd.to_datetime(df['open_date'])
a = df['open_date'] >= '2025-07-01'
b = df['open_date'] <= '2025-12-31'

# 2. 수강인원(students)이 30명 이상 이다. (30명 포함)
c = df['students'] >= 30

ans = len(df.loc[a & b & c, : ])
print(ans)