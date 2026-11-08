# 작업형1번의 문제1

# 주어진 데이터에서 매장코드별, 고객유형별 총매출액 합계를 계산한 후,
# 매장코드별 고객유형(일반 고객 vs VIP 고객) 간의 총매출액 합계의 차이를 절대값으로 계산한 뒤,
# 그 중 절대값이 가장 큰 매장코드 번호를 출력하시오.

import pandas as pd

# 데이터 불러오기
df = pd.read_csv("sales_data.csv")
df
# pivot_table을 사용하여 매장코드별, 고객유형별 총매출액 합계 계산
df2 = df.pivot_table(index='매장코드', columns='고객유형', values='총매출액', aggfunc='sum')

# 고객유형 간 매출 차이 계산 및 절대값
df2['diff'] = abs(df2[1] - df2[2])

# 차액 절대값이 가장 큰 매장코드 찾기
ans = df2['diff'].idxmax()
print(ans)