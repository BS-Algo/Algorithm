#답:

import pandas as pd

# CSV 파일에서 데이터 로드
df = pd.read_csv('department_project_data.csv')
# df

# 부서당 프로젝트 수 구하기
df['전체 프로젝트'] = df['1프로젝트'] + df['2프로젝트'] + df['3프로젝트'] + df['4프로젝트'] + df['5프로젝트']
# df

# 직원 한 명당 담당하는 프로젝트 수가 구하기
df['프로젝트수 / 직원수'] = df['전체 프로젝트'] / df['직원수']
df

# 프로젝트 수가 가장 많은 부서 구하기
max_dept = df.loc[df['프로젝트수 / 직원수'] == df['프로젝트수 / 직원수'].max(), '직원수'].values[0]
max_dept
 
# 그 부서의 총 직원 수를 구하기
print(max_dept)