# 출력을 원하실 경우 print() 함수를 사용하세요.
# 코드는 수정 가능하며, 최종 결과만 print 하세요.
import pandas as pd

# 데이터 읽기
df = pd.read_csv("data_usage.csv")
df.head(30)

# 1.주어진 데이터셋에서 연도(Year)별로 가스 사용량(Gas_Usage) 이 가장 많은 행들을 골라냅니다.
max_idx = df.groupby('Year')['Gas_Usage'].idxmax()
max_idx

# 2.골라낸 행들중에서 가장 많이 등장한 국가(최빈 국가) 를 찾는다.
df2 = df.iloc[max_idx,: ]
v_c = df2.value_counts('Country')

# 3.가장 많이 등장한 국가가 몇번 출현했는지 등장한 횟수를 출력하시오
ans = v_c[0]
print(ans)

# 출력을 원하실 경우 print() 함수를 사용하세요.
# 코드는 수정 가능하며, 최종 결과만 print 하세요.
import pandas as pd

# 데이터 읽기
df = pd.read_csv("data_usage.csv")
df.head(30)

# 1. 가스 사용량(Gas_Usage) 컬럼의 모든 값에 대해 제곱근(Square Root) 값을 계산하여
#    새로운 변수로 정의한다.
import numpy as np

df['Gas_Usage_Sqrt'] = np.sqrt(df['Gas_Usage'])

# 2. 2020년 데이터만을 필터링한다.
df_2020 = df.loc[df['Year'] == 2020, ]

# 3. 필터링된 데이터에 대해 1번 과정에서 생성한 제곱근 가스 사용량의 평균(Mean) 을 계산하시오.
gas_mean = df_2020['Gas_Usage_Sqrt'].mean()

# 4. 최종 결과값은 소수점 셋째 자리에서 반올림하여 소수점 둘째 자리까지
#    출력하시오. (예: 12.345 -> 12.35)
ans = round(gas_mean, 2)
print(ans)