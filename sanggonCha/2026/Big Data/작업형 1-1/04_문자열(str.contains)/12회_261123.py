# 출력을 원하실 경우 print() 함수를 사용하세요.
# 코드는 수정 가능하며, 최종 결과만 print 하세요.
import pandas as pd

# 데이터 읽기
df = pd.read_csv("lecture.csv")
df.head(10)

# 1. 강의명(lecture_name)에 'Python'이 들어 있는지 확인한다. (대소문자 구분 없음)
c1 = df['lecture_name'].str.contains('Python', case=False)

# 2. 강의명(lecture_name)에 '파이썬'이 들어 있는지 확인한다.
c2 = df['lecture_name'].str.contains('파이썬', case=False)

# 3. 두 단어 중 하나라도 들어 있는 강의만 골라낸다. (| 는 '또는')
ans = len(df.loc[c1 | c2, : ])

# 4. 골라낸 강의가 몇 개인지 출력한다.
print(ans)