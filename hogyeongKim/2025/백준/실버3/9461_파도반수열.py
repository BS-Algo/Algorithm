for _ in range(int(input())):
    n = int(input())
    
    dp = [1] * (n+2)
    
    for i in range(4, n+1):
        dp[i] = dp[i-2] + dp[i-3]
        
    print(dp[n])