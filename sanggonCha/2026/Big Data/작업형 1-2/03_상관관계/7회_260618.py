#문제:
# 주어진 데이터의 여러 측정 항목 중 사용자의 운동 시간(duration)과
# 가장 상관관계가 높은 변수를 찾아, 해당 변수의 평균값을 구하세요.
# 결과는 소수 셋째 자리까지 반올림하시오.

# 답:
# Step 1: 상관관계 계산

df.corr().iloc[0, 1: ]

# Step 2: 'duration'과 가장 상관관계가 높은 변수 찾기
max_var = abs(df.corr().iloc[0, 1: ]).idxmax()

# Step 3: 해당 변수의 평균값 구하기
a = df.loc[ : , max_var].mean()
ans = round(a, 3)
print(ans)