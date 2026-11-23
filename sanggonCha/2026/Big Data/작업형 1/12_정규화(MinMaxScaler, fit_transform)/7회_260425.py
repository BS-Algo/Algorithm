# #7회 작업형1 문제1

# 주어진 데이터에서 결측치를 제거한 후, 사용자가 가장 적게 참여한 활동 번호(id)을
# 찾고, 해당 활동의 점수(score)를 MinMaxScaler로 정규화한 뒤, 정규화된 점수의 중앙값을
# 구하세요. 결과는 소수 둘째 자리까지 반올림하시오.

# 답:
# 주어진 데이터에서 결측치를 제거한 후,
import pandas as pd

df = pd.read_csv('data_large.csv')  # 파일 로드
df.isnull().sum()
df = df.dropna() # df.dropna(inplace=True): 이렇게 하면 원본 데이터프레임에 바로 적용하기 때문에 옮겨담을 필요 없음
df.isnull().sum()

# 사용자가 가장 적게 참여한 활동 번호(id)를  찾고
df['id'].value_counts().idxmin()
df2 = df.loc[df['id'] == 3, : ]
df2


# 해당 활동의 점수(score)를 MinMaxScaler로 정규화한 뒤
from sklearn.preprocessing import MinMaxScaler

scaler = MinMaxScaler()

type(df2['score']) # series
type(df2[['score']]) # dataframe

# df2['score'] = scaler.fit_transform(df2['score']) # ValueError: Expected a 2-dimensional container but got <class 'pandas.core.series.Series'> instead.
df2['score'] = scaler.fit_transform(df2[['score']])
df2

# 정규화된 점수의 중앙값을 구하세요. 결과는 소수 둘째 자리까지 반올림하시오.
q2 = df2['score'].quantile(0.5)
q2 = df2['score'].median()
print(round(q2, 2))