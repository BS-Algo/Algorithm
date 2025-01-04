from collections import deque

def bfs(k, x):
    queue = deque()
    queue.append(x)
    visited[x] = 1

    ans = []

    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = 1
                dist[i] = dist[v] + 1

                if dist[i] == k:
                    ans.append(i)

    if len(ans) == 0:
        return -1
    else:
        return ans

n, m, k, x = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
dist = [0] * (n+1)
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

result = bfs(k, x) #k: 거리, x: 출발점 => 오름차순 출력

if result == -1:
    print(-1)
else:
    result = sorted(result)
    for i in result:
        print(i)