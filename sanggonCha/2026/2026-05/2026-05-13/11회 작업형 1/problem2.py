# 출력을 원하실 경우 print() 함수를 사용하세요.
# 코드는 수정 가능하며, 최종 결과만 print 하세요.
import pandas as pd

# 데이터 읽기
df = pd.read_csv("data_usage.csv")
df.head(30)

# 1. 가스 사용량(Gas_Usage) 컬럼의 모든 값에 대해 제곱근(Square Root) 값을 계산하여
#    새로운 변수로 정의한다.
df['sqrt_Gas_Usage'] = df['Gas_Usage'] ** 0.5
df

# 2. 2020년 데이터만을 필터링한다.
a = df.loc[df['Year'] == 2020 , :]
a

# 3. 필터링된 데이터에 대해 1번 과정에서 생성한 제곱근 가스 사용량의 평균(Mean) 을 계산하시오.
m = a['sqrt_Gas_Usage'].mean()
m

# 4. 최종 결과값은 소수점 셋째 자리에서 반올림하여 소수점 둘째 자리까지
#    출력하시오. (예: 12.345 -> 12.35)
ans = round(m, 2)
print(ans)