#문제:

# 회사에서 직원 한 명당 담당하는 프로젝트 수가 가장 많은 부서를 찾고,
# 그 부서의 총 직원 수를 구하세요.

#답:

import pandas as pd

# CSV 파일에서 데이터 로드
df = pd.read_csv('department_project_data.csv')
df['total'] =  + df['1프로젝트'] + df['2프로젝트'] + df['3프로젝트'] + df['4프로젝트'] + df['5프로젝트']
df['ratio'] = df['total'] / df['직원수']
maxidx = df['ratio'].idxmax()
ans = df.iloc[maxidx, 1]
print(ans)