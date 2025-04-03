T = int(input())
for _ in range(T):
    k = int(input())
    n = int(input())
    dp = [0] * n
    for i in range(n):
        dp[i] = i+1
    
    for j in range(k):
        for i in range(1, n):
            dp[i] += dp[i-1]
    print(dp[n-1])
    
    

