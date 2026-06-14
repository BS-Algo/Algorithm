#답:

import pandas as pd

# CSV 파일에서 데이터 로드
df = pd.read_csv('department_project_data.csv')
df['총 프로젝트'] = df['1프로젝트'] + df['2프로젝트'] + df['3프로젝트'] + df['4프로젝트'] + df['5프로젝트']
df['인당 프로젝트'] = df['총 프로젝트'] / df['직원수']
max_pj = df['인당 프로젝트'].max()
ans = df.loc[df['인당 프로젝트'] == max_pj, '직원수'].iloc[0]
print(ans)