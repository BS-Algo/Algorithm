from collections import deque

def bfs(graph, start, visited, parent):
    queue = deque([start])
    visited[start] = True

    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                parent[i] = v       # 부모 노드 저장

N = int(input())
graph = [[] for _ in range(N+1)]
for i in range(N-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (N+1)
parent = [0] * (N+1)

bfs(graph, 1, visited, parent)

for i in range(2, N+1):
    print(parent[i])

