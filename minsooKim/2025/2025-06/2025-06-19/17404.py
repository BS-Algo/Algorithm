N = int(input())
house = [list(map(int, input().split())) for _ in range(N)]
max_nm = 1e9
answer = 1e9
for i in range(3):
    dp = [[max_nm] * 3 for _ in range(N)]
    dp[0][i] = house[0][i] 
    for j in range(1, N):
        dp[j][0] = house[j][0] + min(dp[j-1][1], dp[j-1][2])
        dp[j][1] = house[j][1] + min(dp[j-1][0], dp[j-1][2])
        dp[j][2] = house[j][2] + min(dp[j-1][0], dp[j-1][1])
    dp[N-1][i] = 1e9

    answer = min(answer, min(dp[N-1]))
print(answer)
        
