from math import sqrt

n = int(input())
dp = [0] * (n+1)
dp[1] = 1

for i in range(1, n+1):
    dp[i] = dp[i-1] + 1
    for j in range(2, int(sqrt(i)) + 1):
        dp[i] = min(dp[i], dp[i-(j**2)]+1)

print(dp[n])