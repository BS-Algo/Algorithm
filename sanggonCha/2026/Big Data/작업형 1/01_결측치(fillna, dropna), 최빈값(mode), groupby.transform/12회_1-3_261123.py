# 출력을 원하실 경우 print() 함수를 사용하세요.
# 코드는 수정 가능하며, 최종 결과만 print 하세요.
import pandas as pd

# 데이터 읽기
# (years 컬럼에 'TF-신사업' 같은 문자와 숫자가 섞여 있으므로 모두 문자열로 읽는다)
df = pd.read_csv("hr_export.csv", dtype=str)
df.head()

# 작업형 1-5 (배점 5점)
# 📌 시나리오
# hr_export.csv 의 데이터를 올바른 형태(emp_id, dept, sub_dept, years, grade)로 복원한 뒤, 전체 직원의 평균 근속연수 를 구하시오.
c = df['memo'].notna()
df.loc[c, :]
df['겸직'] = None
df.loc[c, '겸직'] = df.loc[c, 'years']
df.loc[c, 'years'] = df.loc[c, 'grade']
df.loc[c, 'grade'] = df.loc[c, 'memo']
df.drop(columns='memo')
ans = round(df['years'].astype(int).mean(), 2)
print(ans)

# hr_export.csv 를 작업형 1-5와 같이 복원한 데이터 에서 부서(dept)별 겸직자 비율(%) 을 구하고, 그 비율이 가장 높은 부서의 비율 을 구하시오.
df2 = df.groupby('dept')['emp_id'].count()
df3 = df.loc[df['겸직'].notna(), : ]
df4 = df3.groupby('dept')['emp_id'].count()
df5 = df4 / df2
ans2 = round(df5.max() * 100, 2)
print(ans2)