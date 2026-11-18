import pandas as pd

df = pd.read_csv('education_data.csv') 
df.head(20)

#작업 1) 매출 기여도 분석

# 1.소주제별 정답률을 기준으로 상위 2개 소주제를 선정하시오
ja = df.groupby('소주제')['정답여부'].sum() # 분자
mo = df.groupby('소주제')['학생id'].count() # 분모
juje = (ja / mo).sort_values(ascending=False).iloc[0:2].index

# 2. 해당 2개 소주제에서 발생한 총 매출액을 계산하시오

ans = 0
for j in juje:
  s = df.loc[df['소주제'] == j, '매출액'].sum()
  ans += s
print(ans)