N = int(input())
dp = [0] + list(map(int, input().split()))
# N = 4
for i in range(2, N+1):
    # i = 2, 3, 4
    for j in range(i):
        dp[i] = max(dp[i], dp[j]+dp[i-j])
print(dp)