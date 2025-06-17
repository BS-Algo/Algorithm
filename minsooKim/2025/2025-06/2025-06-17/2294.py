n, k = map(int, input().split())
lst = []
for _ in range(n):
    coin = int(input())
    lst.append(coin)
dp = [10001] * (k+1)
dp[0] = 0
for l in lst:
    for i in range(l, k+1):
        dp[i] = min(dp[i-l] + 1, dp[i])
if dp[k] != 10001:
    print(dp[k])
else:
    print(-1)