# 라이브러리 불러오기
import pandas as pd

# 데이터 불러오기
df = pd.read_csv("coffee_data.csv")
# df

# 지역('region')별 커피 소비량('coffee_servings')의 평균을 계산하고 평균이 가장 높은 지역을 찾으세요.
max_region = df.groupby('region')['coffee_servings'].mean().idxmax()

# 해당 지역에서 커피 소비량이 3번째로 많은 도시 찾기
df3 = df.loc[df['region'] == max_region, : ]
df3
answer = df3.nlargest(3, 'coffee_servings').values[2][2]

print(answer)