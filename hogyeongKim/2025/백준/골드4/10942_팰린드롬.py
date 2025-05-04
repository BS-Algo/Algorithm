import sys
input = sys.stdin.readline

n = int(input())
numbers = list(map(int, input().split()))

m = int(input())
checklist = [tuple(map(int, input().split())) for _ in range(m)]
dp = [[0] * n for _ in range(n)]

for i in range(n):
    dp[i][i] = 1

for i in range(n-1):
    if numbers[i] == numbers[i+1]:
        dp[i][i+1] = 1
        
for i in range(3, n+1):
    for start in range(n - i + 1):
        end = i + start - 1
        if numbers[start] == numbers[end]:
            if dp[start+1][end-1]:
                dp[start][end] = 1

for s, e in checklist:
    print(dp[s-1][e-1])