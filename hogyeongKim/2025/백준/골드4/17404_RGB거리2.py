# 백트래킹(메모이제이션), DP

n= int(input())

rgb_costs = [list(map(int, input().split())) for _ in range(n)]
mn_costs = float('inf')

# 첫 집 색깔 고정
for first_color in range(3):
    dp = [[float('inf')] * 3 for _ in range(n)]
    
    for house_color in range(3):
        if house_color == first_color:
            dp[0][house_color] = rgb_costs[0][house_color]
    
    for i in range(1, n):
        # 현재 집
        for j in range(3):
            # 이전 집
            for k in range(3):
                # 이전 집과 다를 때 두번 확인
                if j != k:
                    dp[i][j] = min(dp[i][j], dp[i-1][k] + rgb_costs[i][j])
    
    # 마지막 집 색은 첫 집의 색과 달라야 하므로 별도로 체크
    for last_color in range(3):
        if last_color != first_color:
            mn_costs = min(mn_costs, dp[n-1][last_color])        
    
print(mn_costs)