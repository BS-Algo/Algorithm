# Step 1: 상관관계 계산
df_corr = df.corr() # 상관관계

# Step 2: 'duration'과 가장 상관관계가 높은 변수 찾기
df_corr_drop = df_corr['duration'].drop('duration')
df_corr_drop

# Step 3: 해당 변수의 평균값 구하기
col1 = df_corr_drop.abs().idxmax()
answer = df[col1].mean()
print(round(answer, 3))