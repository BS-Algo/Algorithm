# 답:
# Step 1: 상관관계 계산
df_corr = df.corr()
max_var = df_corr.loc[df_corr['duration'] != 1, 'duration'].abs().idxmax()

a = df[max_var].mean()
ans = round(a, 3)
print(ans)