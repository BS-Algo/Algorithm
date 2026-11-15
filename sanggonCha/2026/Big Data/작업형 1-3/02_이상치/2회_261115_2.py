# 이상치 - "평균 +- 2 * 표준편차"

# 답:
#1. 데이터 로드
import  pandas  as  pd
df = pd.read_csv("customers.csv")

#문제
# 주어진 데이터셋(customers.csv)의 purchase_amount 컬럼의 이상치를 모두 더하세요!
# 이상치의 기준은 평균으로부터 표준편차 * 2를 벗어나는 영역을 이상치라고 판단합니다.
m = df['purchase_amount'].mean()
s = df['purchase_amount'].std()
up = m + 2 * s
lo = m - 2 * s
ans = df.loc[(df['purchase_amount'] > up) | (df['purchase_amount'] < lo), 'purchase_amount'].sum()
print(ans)