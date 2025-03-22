# Knapsack 문제, 백트래킹(시간 초과)
# def knapsack(idx, weights, prices):
#     global mx_prices
#     if weights > K:
#         return
        
#     if idx == N:
#         mx_prices = max(mx_prices, prices)
#         return
        
#     # 물건을 선택한 경우
#     knapsack(idx+1, weights+items[idx][0], prices+items[idx][1])
#     # 물건을 선택하지 않은 경우
#     knapsack(idx+1, weights, prices)

# N, K = map(int, input().split())

# items = [tuple(map(int, input().split())) for _ in range(N)]
# mx_prices = 0
# knapsack(0, 0, 0)

# 다이나믹 프로그래밍
def dp_knapsack(idx, weights):
    global K, N
    if idx == N:
        return 0
        
    if weights > K:
        return -float('inf')
    
    if dp[idx][weights]!= -1:
        return dp[idx][weights]
        
    take = -float('inf')
    if weights + items[idx][0] <= K:
        take = dp_knapsack(idx+1, weights+items[idx][0]) + items[idx][1]
    dont_take = dp_knapsack(idx+1, weights)
    
    dp[idx][weights] = max(take, dont_take)
        
    return dp[idx][weights]

N, K = map(int, input().split())

items = [tuple(map(int, input().split())) for _ in range(N)]
dp = [[-1] * (K+1) for _ in range(N+1)]

dp_knapsack(0, 0)
print(dp[0][0])