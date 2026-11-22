# 출력을 원하실 경우 print() 함수를 사용하세요.
# 코드는 수정 가능하며, 최종 결과만 print 하세요.
import pandas as pd

# 1. 데이터 읽기
df = pd.read_csv("data_q1_2.csv")
df.head(20)

# 1.제공된 데이터셋의 컬럼 중 결측치(Missing Value) 가 가장 많은 컬럼을 찾는다.
m_c = df.isnull().sum().idxmax()
# 2.해당 컬럼의 결측치를 그 컬럼의 중앙값(Median) 으로 대치(Imputation)한다.
df[m_c] = df[m_c].fillna(df[m_c].median())

# 3. 대치 후, 보정된 해당 컬럼의 평균(Mean) 을 계산하시오.
ans = round(df[m_c].mean(), 2)
# 4.최종 결과값은 소수점 셋째 자리에서 반올림하여 소수점 둘째 자리 까지 출력하시오.
print(ans)