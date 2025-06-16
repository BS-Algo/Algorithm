n, k = map(int, input().split())
lst = []
for _ in range(n):
    coin = int(input())
    lst.append(coin)
dp = [0] * (k + 1)
dp[0] = 1
for l in lst:
    for i in range(l, k+1):
        dp[i] = dp[i] + dp[i-l]
print(dp[k])