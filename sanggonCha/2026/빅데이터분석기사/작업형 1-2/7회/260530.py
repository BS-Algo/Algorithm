#문제:
# 주어진 데이터의 여러 측정 항목 중 사용자의 운동 시간(duration)과
# 가장 상관관계가 높은 변수를 찾아, 해당 변수의 평균값을 구하세요.
# 결과는 소수 셋째 자리까지 반올림하시오.

# 1. 운동 시간(duration)과 가장 상관관계가 높은 변수를 찾기
# 1-1. 상관계수 찾기
result = df.corr()
result2 = result['duration'].drop('duration')

# 1-2상관계수가 가장 큰 변수 찾기
max_var = result2.abs().idxmax()

# 2. 해당 변수의 평균값을 구하기
a = df.loc[ : , max_var].mean()

# 3. 결과는 소수 셋째 자리까지 반올림하기
b = round(a, 3)
print(b)
