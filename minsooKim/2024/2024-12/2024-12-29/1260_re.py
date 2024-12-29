from collections import deque
def bfs(start, visited, result_2):
    queue = deque([start])
    visited[start] = True
    result_2.append(start)
    while queue:
        x = queue.popleft()
        for i in graph[x]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
                result_2.append(i)

def dfs(start, visited, result):
    visited[start] = True
    result.append(start)
    for i in graph[start]:
        if not visited[i]:
            visited[i] = True            
            dfs(i, visited, result)
    

N, M, V = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
for k in graph:
    k.sort()

visited = [False] * (N+1)
visited_2 = [False] * (N+1)
result = []
result_2 = []
dfs(V, visited, result)
print(*result)
bfs(V, visited_2, result_2)
print(*result_2)