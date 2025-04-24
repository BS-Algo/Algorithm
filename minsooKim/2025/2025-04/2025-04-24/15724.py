N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
K = int(input())
dp = [[0] * (M + 1) for _ in range(N + 1)]
#             0 0  0  0  0
# 1 2 3 8  => 0 1  3  6 14
# 2 5 1 3  => 0 3 10 14 25
# 4 3 4 2  => 0 7 17 25 38
# 1 5 5 2  => 0 8 23 36 51
for i in range(1, N + 1):
    for j in range(1, M + 1):
        # dp[2][2] = dp[2][1] + dp[1][2] + arr[1][1] - dp[1][1]
        dp[i][j] = dp[i][j-1] + dp[i-1][j] + arr[i-1][j-1] - dp[i-1][j-1]
for _ in range(K):
    x1, y1, x2, y2 = map(int, input().split())
    print(dp)
    print(dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1])