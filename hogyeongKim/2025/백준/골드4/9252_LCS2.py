import sys
input = sys.stdin.readline

row = input().rstrip()
col = input().rstrip()
n, m = len(row), len(col)
dp = [[0] * (m+1) for _ in range(n+1)]

for i in range(1, n+1):
    for j in range(1, m+1):
        if row[i-1] == col[j-1]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])

print(dp[n][m])
if dp[n][m] > 0:
    result = ''
    i, j = n, m
    
    while i > 0 and j > 0:
        if row[i-1] == col[j-1]:
            result += row[i-1]
            i-=1
            j-=1
        elif dp[i-1][j] > dp[i][j-1]:
            i -= 1
        else:
            j -= 1
    print(result[::-1])