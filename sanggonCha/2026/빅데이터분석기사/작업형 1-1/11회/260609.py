# 출력을 원하실 경우 print() 함수를 사용하세요.
# 코드는 수정 가능하며, 최종 결과만 print 하세요.
import pandas as pd

# 데이터 읽기
df = pd.read_csv("data_usage.csv")
df.head(30)

# 1.주어진 데이터셋에서 연도(Year)별로 가스 사용량(Gas_Usage) 이 가장 많은 행들을 골라냅니다.
df.Country.unique()
idx = df.groupby('Year')['Gas_Usage'].idxmax()
df2 = df.loc[ idx , : ] 

# 2.골라낸 행들중에서 가장 많이 등장한 국가(최빈 국가) 를 찾는다.
df3 = df2['Country'].value_counts().reset_index()

# 3.가장 많이 등장한 국가가 몇번 출현했는지 등장한 횟수를 출력하시오.
c = df3.loc[0, ['count']]
result = c[0]
print(result)