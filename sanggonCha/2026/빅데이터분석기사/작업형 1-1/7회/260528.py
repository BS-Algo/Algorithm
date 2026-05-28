#7회 작업형1 문제1

# 주어진 데이터에서 결측치를 제거한 후, 사용자가 가장 적게 참여한 활동 번호(id)을
# 찾고, 해당 활동의 점수(score)를 MinMaxScaler로 정규화한 뒤, 정규화된 점수의 중앙값을
# 구하세요. 결과는 소수 둘째 자리까지 반올림하시오.

# 답:
# 주어진 데이터에서 결측치를 제거한 후,
import pandas as pd

df = pd.read_csv('data_large.csv')  # 파일 로드

df.isnull().sum() # id: 0, score: 20
df2 = df.dropna() # inplcae=True 하면 원본 데이터 df를 직접 수정하기 때문에 df2에 옮겨담을 필요 없음
df2.isnull().sum() # id: 0, score: 0

# 사용자가 가장 적게 참여한 활동 번호(id) 찾기
min_id = df2['id'].value_counts().idxmin()
min_id

# 해당 활동의 점수(score)를 MinMaxScaler로 정규화하기 
df3 = df2.loc[df['id'] == min_id, : ]

from sklearn.preprocessing import MinMaxScaler

scaler = MinMaxScaler()
scaler.fit(df3[['score']])
df3['score'] = scaler.transform(df3[['score']])
df3

# 정규화된 점수의 중앙값 구하기
q2 = df3['score'].quantile(0.5)
q2

# 결과는 소수 둘째 자리까지 반올림하기
a = round(q2, 2)
print(a) # 0.52