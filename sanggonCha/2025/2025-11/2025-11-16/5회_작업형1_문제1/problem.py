#답:
import pandas as pd

# CSV 파일에서 데이터 로드
df = pd.read_csv('product_data.csv')
# df

# 특정 회사의 제품 데이터에서 제품종류가 '일반제품'이고, 용도가 '음식물처리'인 제품
df2 = df.loc[ (df['제품종류'] == '일반제품') & (df['용도'] == '음식물처리'), : ]

# 제품 중 1L 가격의 평균을 구하세요
mean_price = df['1L 가격'].mean()

# 출력되는 결과는 반올림하여 정수로 제출하세요.
print(round(mean_price))