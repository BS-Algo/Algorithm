#백트래킹, 다이나믹 프로그래밍
# def back(idx, prices):
#     global mx_prices
#     # 모든 상담을 마지막 날짜에 맞춰 잘 마친 경우
#     if idx == N:
#         mx_prices = max(mx_prices, prices)
#         return
#     # 상담한 날짜가 초과한 경우
#     if idx > N:
#         return
    
#     #상담을 하는 경우
#     back(idx+interviews[idx][0], prices+interviews[idx][1])
    
#     #상담을 하지 않는 경우
#     back(idx+1, prices)

# N = int(input())
# mx_prices = 0
# interviews = [list(map(int, input().split())) for _ in range(N)]

# back(0, 0)
# print(mx_prices)

N = int(input())
dp = [-1] * (N + 1)
mx_prices = 0
interviews = [list(map(int, input().split())) for _ in range(N)]

# 메모이제이션 사용한 재귀함수

def dp_back(idx):
    global mx_prices
    if idx == N:
        return 0
    if idx > N:
        return -float('inf')
    
    if dp[idx]!= -1:
        return dp[idx]
        
    dp[idx] = max(dp_back(idx+interviews[idx][0]) + interviews[idx][1], dp_back(idx+1))
    
    return dp[idx]
    
dp_back(0)
print(dp[0])