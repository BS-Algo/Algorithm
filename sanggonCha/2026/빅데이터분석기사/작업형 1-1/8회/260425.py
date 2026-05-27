# 문제1

# 1-1. 지역('region')별 커피 소비량('coffee_servings')의 평균을 계산하고, 평균이 가장 높은 지역을 찾으세요.


# 답:

# 라이브러리 불러오기
import pandas as pd

# 데이터 불러오기
df = pd.read_csv("coffee_data.csv")

# 지역('region')별 커피 소비량('coffee_servings')의 평균을 계산하고
df2 = df.groupby('region')['coffee_servings'].mean()
df2

# 평균이 가장 높은 지역을 찾으세요.
df2.idxmax()


# 1-2. 1번에서 찾은 지역에서 커피 소비량이 3번째로 많은 도시('city')의 커피 소비량을 구하세요

# 문제를 더 명확하게 정리하면 다음과 같습니다.

#  1번에서 찾은 지역의 데이터 중에서 coffee_servings 값을 기준으로 내림차순 정렬했을 때, 3번째 행의 coffee_servings 값을 구하세요.

# 답:

# 해당 지역에서 커피 소비량이 3번째로 많은 도시 찾기
# df
df3 = df.loc[df['region'] == 'North', : ]
df4 = df3.nlargest(3, 'coffee_servings')
df4['coffee_servings']
result = df4['coffee_servings'].iloc[2]
print(result)