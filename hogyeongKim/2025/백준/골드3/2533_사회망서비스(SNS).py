import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())
graphs = [[] for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, input().split())
    graphs[a].append(b)
    graphs[b].append(a)

dp = [[0, 1] for _ in range(n+1)]
visited = [False] * (n+1)

def dfs(node):
    visited[node] = True
    
    for child_node in graphs[node]:
        if not visited[child_node]:
            dfs(child_node)
            dp[node][0] += dp[child_node][1]
            dp[node][1] += min(dp[child_node][0], dp[child_node][1])

dfs(1)
print(min(dp[1][0], dp[1][1]))