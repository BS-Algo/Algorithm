#7회 작업형1 문제1

# 주어진 데이터에서 결측치를 제거한 후, 사용자가 가장 적게 참여한 활동 번호(id)을
# 찾고, 해당 활동의 점수(score)를 MinMaxScaler로 정규화한 뒤, 정규화된 점수의 중앙값을
# 구하세요. 결과는 소수 둘째 자리까지 반올림하시오.

# 답:
# 주어진 데이터에서 결측치를 제거한 후,
import pandas as pd

df = pd.read_csv('data_large.csv')  # 파일 로드

# 결측치 제거
df2 = df.dropna()

# 가장 적게 참여한 활동 번호 찾기
max_idx = df2['id'].value_counts().idxmin()
df3 = df2.loc[df2['id'] == max_idx, ]

# 정규화
from sklearn.preprocessing import MinMaxScaler

scaler = MinMaxScaler()
df3['score'] = scaler.fit_transform(df3[['score']])

# 중앙값 찾기
q2 = df3['score'].quantile(0.5)
ans = round(q2, 2)
print(ans)