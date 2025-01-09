from collections import deque

def bfs(start):
    queue = deque([(start, 0)])
    visited = [False] * (n+1)
    visited[start] = True
    result = []

    while queue:
        node, cnt = queue.popleft()
       
        for v in graph[node]:
            if not visited[v]:
                visited[v] = True
                if cnt < 2:
                    queue.append((v, cnt + 1))
                    if v not in result:
                        result.append(v)
    return result
                

n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
print(bfs(1))
