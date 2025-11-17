# 주어진 데이터에서 결측치를 제거한 후,
import pandas as pd

df = pd.read_csv('data_large.csv')  # 파일 로드
# df.isnull().sum()
df.dropna(inplace=True) # 결측치 제거

# 사용자가 가장 적게 참여한 활동 번호(id)를  찾고
df['id'].value_counts().idxmin()
df2 = df.loc[ df['id'] == 3, : ]

# 해당 활동의 점수(score)를 MinMaxScaler로 정규화한 뒤
from sklearn.preprocessing import MinMaxScaler

type(df2['score']) # Series
type(df2[['score']]) # DataFrame
scaler = MinMaxScaler()
df2['score'] = scaler.fit_transform(df2[['score']])
df2

# 정규화된 점수의 중앙값을 구하세요. 결과는 소수 둘째 자리까지 반올림하시오.
result = df2['score'].median()
print(round(result, 2))