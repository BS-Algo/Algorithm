N = int(input())
arr = list(map(int, input().split()))
dp = [0] * N

for i in range(N):
    mx, mn = arr[i], arr[i]
    for j in range(i+1, N):
        x = dp[i-1]
        mx = max(mx, arr[j])
        mn = min(mn, arr[j])
        dp[j] = max(dp[j], mx-mn+x)
print(dp[-1])