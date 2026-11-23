#문제:
# 주어진 데이터의 여러 측정 항목 중 사용자의 운동 시간(duration)과
# 가장 상관관계가 높은 변수를 찾아, 해당 변수의 평균값을 구하세요.
# 결과는 소수 셋째 자리까지 반올림하시오.
max_var = abs(df.corr().drop('duration')['duration']).idxmax()
ans = round(df[max_var].mean(), 3)
print(ans)