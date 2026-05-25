#답:

import pandas as pd

# CSV 파일에서 데이터 로드
df = pd.read_csv('department_project_data.csv')
df

#문제:

# 총 프로젝트 수 컬럼 만들기
df['총 프로젝트'] = df['1프로젝트'] + df['2프로젝트'] + df['3프로젝트'] + df['4프로젝트'] + df['5프로젝트']

# 직원 한 명당 프로젝트 수 컬럼 만들기
df['인당 프로젝트 수'] = df['총 프로젝트'] / df['직원수']

# 직원 한 명당 담당하는 프로젝트 수가 가장 많은 부서를 찾기
df['인당 프로젝트 수'].max()
maxidx = df['인당 프로젝트 수'].idxmax()

# 그 부서의 총 직원 수를 구하기
a = df.iloc[maxidx, 1]
print(a)