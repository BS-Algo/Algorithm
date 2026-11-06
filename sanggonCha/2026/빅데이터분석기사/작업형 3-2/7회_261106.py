#답:
# 데이터 불러오기
import pandas as pd
df = pd.read_csv('financial.csv')
df2 = df.corr()
df3 = df2.drop('Sales')
df4 = df3['Sales']
max_col = df4.idxmax()
max_val = round(df4.max(), 3)
print(max_col, max_val)

