# 출력을 원하실 경우 print() 함수를 사용하세요.
# 코드는 수정 가능하며, 최종 결과만 print 하세요.
import pandas as pd
import numpy as np

# 1. 데이터 읽기
df = pd.read_csv("data_q1_3.csv")
df.head(30)

#  1. [파생변수 1 생성] Code 컬럼의 문자열에 알파벳 'c'가 포함되어 있으면 'A',
#     포함되어 있지 않으면 'B' 값을 가지는 Type 컬럼을 생성 하시오.
import numpy as np
df['Type'] = np.where(df['Code'].str.contains('c'), 'A', 'B')

#  2.[파생변수 2 생성] Code 컬럼에서 'c' 문자를 제거한 뒤,
#     이를 정수형(int) 으로 변환하여 Clean_Code 컬럼을 생성하시오.
#     (음수 기호 '-'는 유지되어야 함)
df['Clean_Code'] = df['Code'].str.replace('c', '').astype(int)
df

# 3. [조건부 집계] Type이 'A' 인 데이터 중에서, Clean_Code 값의 평균(Mean) 을 구하시오
df_mean = df.loc[df['Type'] == 'A', 'Clean_Code'].mean()

# 4. 결과 출력 (소수점 둘째 자리)
ans = round(df_mean, 2)
print(ans)
