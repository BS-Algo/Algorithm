n, s, m = map(int, input().split())
vol_lst = list(map(int, input().split()))

dp = [[0] * (m+1) for i in range(n+1)]
dp[0][s] = 1

for i in range(1, n+1):
    for j in range(m+1):
        if dp[i-1][j]:
            if 0 <= j + vol_lst[i-1] <= m:
                dp[i][j+vol_lst[i-1]] = 1
            if 0 <= j - vol_lst[i-1] <= m:
                dp[i][j-vol_lst[i-1]] = 1

ans = -1
for i in range(m+1):
    if dp[n][i] == 1:
        ans = max(ans, i)

print(ans)