import math

N = int(input())
dp = [0] * 30
# 제곱수로 이루어진 것들은 싹다 1처리
for i in range(1, int(math.sqrt(N))+1):
    dp[i**2] = 1
dp[2] = 2
dp[3] = 3

# dp[12] = 4 + 4 + 4
# dp[13] = dp[12] + 1
# dp[13] = 3제곱 + 2제곱 = 2
# 만약에 dp[12] = 3
# i가 2가들어왔어요. 그러면 dp[i-j**2] + 1 < mx_cnt:
# mx_cnt = dp[i-j**2] + 1
# dp[i] = mx_cnt
print(dp)
# N = 25
# i = 1 ~ 25
for i in range(1, N+1):
    mx_cnt = 4   
    if dp[i] == 0:
        for j in range(1, int(math.sqrt(i))+1):
            if dp[i-j**2] + 1 < mx_cnt:
                mx_cnt = dp[i-j**2] + 1
        dp[i] = mx_cnt
print(dp[N])
