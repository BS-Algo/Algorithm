import sys
sys.setrecursionlimit(10**5)

def dfs(start):
    global cnt
    visited[start] = cnt

    for v in graph[start]:
        if not visited[v]:
            cnt += 1
            dfs(v)

N, M, R = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(1, N+1):
    graph[i].sort(reverse=True)

visited = [0] * (N+1)
cnt = 1
dfs(R)

for i in range(1, N+1):
    print(visited[i])