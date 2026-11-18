# 작업형1번의 문제1

# 주어진 데이터에서 매장코드별, 고객유형별 총매출액 합계를 계산한 후,
# 매장코드별 고객유형(일반 고객 vs VIP 고객) 간의 총매출액 합계의 차이를 절대값으로 계산한 뒤,
# 그 중 절대값이 가장 큰 매장코드 번호를 출력하시오.

import pandas as pd

# 데이터 불러오기
df = pd.read_csv("sales_data.csv")
df2 = pd.pivot_table(
    data=df, 
    index='매장코드',
    columns='고객유형',
    values='총매출액',
    aggfunc=sum)

ans = (df2.loc[:, 1] - df2.loc[:, 2]).idxmax()
print(ans)