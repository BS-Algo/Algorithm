import sys
input = sys.stdin.readline

n = int(input())
num_lst = [tuple(map(int, input().split())) for _ in range(n)]

# 슬라이딩 윈도우 사용
mx_dp, mn_dp = [[0, 0, 0], [0, 0, 0]], [[0, 0, 0], [0, 0, 0]]

for i in range(n):
    mx_dp[1][0] = max(mx_dp[0][0], mx_dp[0][1]) + num_lst[i][0]
    mx_dp[1][1] = max(mx_dp[0][0], mx_dp[0][1], mx_dp[0][2]) + num_lst[i][1]
    mx_dp[1][2] = max(mx_dp[0][1], mx_dp[0][2]) + num_lst[i][2]
    
    mn_dp[1][0] = min(mn_dp[0][0], mn_dp[0][1]) + num_lst[i][0]
    mn_dp[1][1] = min(mn_dp[0][0], mn_dp[0][1], mn_dp[0][2]) + num_lst[i][1]
    mn_dp[1][2] = min(mn_dp[0][1], mn_dp[0][2]) + num_lst[i][2]
    
    for j in range(3):
        mx_dp[0][j] = mx_dp[1][j]
        mn_dp[0][j] = mn_dp[1][j]
    
print(max(mx_dp[1]), min(mn_dp[1]))