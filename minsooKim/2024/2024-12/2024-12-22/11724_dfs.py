def dfs(graph, v, visited):
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            dfs(graph,i, visited)

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
count = 0
visited = [False] * (N+1)
for i in range(1, N+1):
    if not visited[i]:
        dfs(graph, i, visited)
        count += 1
print(count)

