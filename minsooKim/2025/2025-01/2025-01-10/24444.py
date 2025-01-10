from collections import deque

def bfs(start):
    queue = deque([(start)])
    
    visited[start] = 1
    cnt = 1
    while queue:
        node = queue.popleft()
        for v in graph[node]:
            if not visited[v]:
                cnt += 1
                visited[v] = cnt
                queue.append(v)
N, M, R = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)
visited = [0] * (N+1)

for i in graph:
    i.sort()
bfs(R)

for i in range(1, len(visited)):
    print(visited[i])

