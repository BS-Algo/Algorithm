# 출력을 원하실 경우 print() 함수를 사용하세요.
# 코드는 수정 가능하며, 최종 결과만 print 하세요.
import pandas as pd

# 데이터 읽기
df = pd.read_csv("data_usage.csv")

# 1.주어진 데이터셋에서 연도(Year)별로 가스 사용량(Gas_Usage) 이 가장 많은 행들을 골라냅니다.
df2 = df.pivot_table(index='Country', columns='Year', values='Gas_Usage', aggfunc='max')
df3 = df2.idxmax()
# 2.골라낸 행들중에서 가장 많이 등장한 국가(최빈 국가) 를 찾는다.
ans = df3.value_counts().max()
# 3.가장 많이 등장한 국가가 몇번 출현했는지 등장한 횟수를 출력하시오
print(ans)

# 출력을 원하실 경우 print() 함수를 사용하세요.
# 코드는 수정 가능하며, 최종 결과만 print 하세요.
import pandas as pd

# 데이터 읽기
df = pd.read_csv("data_usage.csv")
# 1. 가스 사용량(Gas_Usage) 컬럼의 모든 값에 대해 제곱근(Square Root)값 을 계산하여 새로운 변수로 정의한다.
# 2. 2020년 데이터만을 필터링 한다.
# 3. 필터링된 데이터에 대해 1번 과정에서 생성한 제곱근 가스 사용량의 평균(Mean) 을 계산하시오.
# 4. 최종 결과값은 소수점 셋째 자리에서 반올림하여 소수점 둘째 자리 까지 출력하시오. (예: 12.345 -> 12.35)
import numpy as np
df['gas_sqrt'] = np.sqrt(df['Gas_Usage'])
df_2020 = df.loc[df['Year'] == 2020, :]
ans = round(df_2020['gas_sqrt'].mean(), 2)
print(ans)