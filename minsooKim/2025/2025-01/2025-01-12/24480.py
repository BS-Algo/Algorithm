import sys
sys.setrecursionlimit(10**9)

def dfs(start):
    global cnt
    visited[start] = cnt
    for v in graph[start]:
        if not visited[v]:
            visited[v] = 1
            cnt += 1
            dfs(v)
N, M, R = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(N):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
for i in graph:
    i.sort(reverse=True)
visited = [0] * (N+1)
cnt = 1
dfs(R)
for i in range(1, N+1):
    print(visited[i])