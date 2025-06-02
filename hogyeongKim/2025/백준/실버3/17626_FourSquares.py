n = int(input())

dp = [4] * (n+1)
for i in range(1, int(n**(1/2))+1):
    dp[i*i] = 1

for i in range(1, n+1):
    for j in range(1, int(i**(1/2))+1):
        dp[i] = min(dp[i], dp[i-j*j] + 1)
print(dp[n])