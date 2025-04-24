import sys
input = sys.stdin.readline

n, m = map(int, input().split())

mars = [tuple(map(int, input().split())) for _ in range(n)]

dp = [[0] * m for _ in range(n)]
dp[0][0] = mars[0][0]

for i in range(1, m):
    dp[0][i] += dp[0][i-1] + mars[0][i]

for i in range(1, n):
    #왼쪽, 오른쪽에서 각각 계산
    left, right = [0] * m, [0] * m
    
    # 왼쪽 시작값
    left[0] = dp[i-1][0] + mars[i][0]
    # 오른쪽 시작값
    right[m-1] = dp[i-1][m-1] + mars[i][m-1]
    
    # 왼쪽부터 누적값
    for j in range(1, m):
        left[j] += max(left[j-1], dp[i-1][j]) + mars[i][j]
    
    # 오른쪽부터 누적값
    for j in range(m-2, -1, -1):
        right[j] = max(right[j+1], dp[i-1][j]) + mars[i][j]
        
    # 왼쪽, 오른쪽 중에 높은 값을 각각 dp에 남김
    for j in range(m):
        dp[i][j] = max(left[j], right[j])
        
print(dp[n-1][m-1])