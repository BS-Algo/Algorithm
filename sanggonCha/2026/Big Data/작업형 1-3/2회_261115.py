# 이상치
# 평균 - mean() / 표준편차 - std())

# 답:
#1. 데이터 로드
import  pandas  as  pd
df = pd.read_csv("customers.csv")

#2. 평균값와 표준편차*2 구하기
#문제

# 주어진 데이터셋(customers.csv)의 purchase_amount 컬럼의 이상치를 모두 더하세요!
# 이상치의 기준은 평균으로부터 표준편차 * 2를 벗어나는 영역을 이상치라고 판단합니다.
upper_bound = df['purchase_amount'].mean() + 2 * df['purchase_amount'].std()
under_bound = df['purchase_amount'].mean() - 2 * df['purchase_amount'].std()
ans = df.loc[(df['purchase_amount'] < under_bound) | (df['purchase_amount'] > upper_bound), 'purchase_amount'].sum()
print(ans)