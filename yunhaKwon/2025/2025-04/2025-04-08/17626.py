import math
n = int(input())
dp = [0] * 50001
for i in range(1, int(math.sqrt(n)) + 1):
    dp[i**2] = 1
dp[2] = 2
dp[3] = 3

for i in range(1, n+1):
    mx = 4
    if dp[i] == 0:
        for j in range(1, int(math.sqrt(i)) + 1):
            if dp[i-j**2] + 1 < mx:
                mx = dp[i-j**2] + 1
        dp[i] = mx

print(dp[n])