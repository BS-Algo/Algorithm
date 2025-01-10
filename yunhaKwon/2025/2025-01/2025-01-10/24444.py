from collections import deque

def bfs(start):
    queue = deque()
    queue.append(start)
    visited[start] = 1
    seq = 2

    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = seq
                seq += 1

N, M, R = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

for g in graph:
    g.sort()

visited = [0] * (N+1)
bfs(R)

for i in range(1, len(visited)):
    print(visited[i])