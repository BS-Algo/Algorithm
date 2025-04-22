N = int(input())
arr = []
for _ in range(N):
    arr.append(int(input()))
dp = [1] * N
# 1 1 1 1 1 1 1
# 3 7 5 2 6 1 4 
# i = 4
# j = 0, 1, 2, 3
# arr[j] = 7 arr[i] = 5
# dp[i] = dp[j] + 1
for i in range(N):
    for j in range(i):
        if arr[j] < arr[i]:
            dp[i] = max(dp[i], dp[j] + 1)
print(N - max(dp))