
#문제

# 주어진 데이터셋(customers.csv)의 purchase_amount 컬럼의 이상치를 모두 더하세요!

# 이상치의 기준은 평균으로부터 표준편차 * 2를 벗어나는 영역을 이상치라고 판단합니다.

# 답:
#1. 데이터 로드
import  pandas  as  pd
df = pd.read_csv("customers.csv")

#2. 평균값와 표준편차*2 구하기
m = df['purchase_amount'].mean()
s = df['purchase_amount'].std(ddof=1)

#3. 이상치 구하기
upper = m + 2 * s
lower = m - 2 * s
outlier = df.loc[(df['purchase_amount'] > upper) | (df['purchase_amount'] < lower), 'purchase_amount']

#4. 이상치들의 합 계산하기
ans = outlier.sum()

#5. 결과 출력하기
print(ans)
