N = int(input())
dp = [0] * (N+1)
dp[1] = 0
for i in range(2, N+1):
    if i % 2 == 0 and i % 3 == 0:
        dp[i] = min(dp[i-1], dp[i//2], dp[i//3]) + 1
    elif i % 2 == 0:
        dp[i] = min(dp[i-1], dp[i//2]) + 1
    elif i % 3 == 0:
        dp[i] = min(dp[i-1], dp[i//3]) + 1
    else:
        dp[i] = dp[i-1] + 1
print(dp[N])

result = []
current = N
while current > 0:
    result.append(current)
    if current % 3 == 0 and dp[current] == dp[current // 3] + 1:
        current //= 3
    elif current % 2 == 0 and dp[current] == dp[current // 2] + 1:
        current //= 2
    else:
        current -= 1
print(*result)


    

