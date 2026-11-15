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

# 출력을 원하실 경우 print() 함수를 사용하세요.
# 코드는 수정 가능하며, 최종 결과만 print 하세요.
import pandas as pd

# 데이터 읽기
df = pd.read_csv("exam_score.csv")

# 0. 작업형 1-3과 똑같이 결측치를 반별 중앙값으로 채운다. (채운 데이터를 그대로 사용)
m= df.groupby('class')['score'].transform('median')
df['score']= df['score'].fillna(m)
df.isnull().sum()
df.head(10)

# 작업형 1-4 (배점 5점)
# 📌 시나리오
# exam_score.csv 에서 작업형 1-3과 같이 결측치를 채운 데이터 를 그대로 사용하여 A반과 B반의 합동분산 을 구하시오.
# 합동분산 : 두 집단의 분산을 인원이 많은쪽에 무게를 더 주어 하나로 합친값. 두 집단의 평균의 차이가 진짜인지 판단할 때 기준 잣대로 쓴다.
 

# 📌 풀이 조건과 주의사항
# 1. 반별로 교육생 수  n  과 점수의 표본분산  s2  을 구한다.
# - 표본분산: 평균과의 차이를 제곱해 모두 더한 뒤  (n−1)  로 나눈 값
a_var = df.loc[df['class'] == 'A', 'score'].var()
b_var = df.loc[df['class'] == 'B', 'score'].var()

a_len = len(df.loc[df['class'] == 'A', 'score'])
b_len = len(df.loc[df['class'] == 'B', 'score'])

# 2. A반과 B반의 값을 아래 식에 대입한다. C반은 사용하지 않는다.
# ((분산1)*(자유도1 + 1) + (분산2)*(자유도2 + 1)) 
# / (자유도1 + 자유도2 - 2)
ans = round(((a_var) * (a_len + 1) + (b_var) * (b_len + 1)) / (a_len + b_len - 2), 2)
print(ans)