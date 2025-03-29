# 백트래킹(메모이제이션), DP

N = int(input())

rgb_costs = [list(map(int, input().split())) for _ in range(N)]

dp = [[0] * 3 for _ in range(N)]

# 초기비용으로 초기화
dp[0] = rgb_costs[0]

# 현재 집까지 오는데 가장 적은 비용은 현재 칠하는 색의 비용과 이전에 다른 색까지 더해진 비용 중 가장 작은 값을 더한 것
for i in range(N):
    dp[i][0] = rgb_costs[i][0] + min(dp[i-1][1], dp[i-1][2])
    dp[i][1] = rgb_costs[i][1] + min(dp[i-1][0], dp[i-1][2])
    dp[i][2] = rgb_costs[i][2] + min(dp[i-1][0], dp[i-1][1])

print(min(dp[N-1]))