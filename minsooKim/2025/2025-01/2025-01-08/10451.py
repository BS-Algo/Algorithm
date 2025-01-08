from collections import deque

def bfs(start):
    queue = deque([(start)])
    visited[start] = True

    while queue:
        node = queue.popleft()
        for v in graph[node]:
            if not visited[v]:
                visited[v] = True
                queue.append(v)

T = int(input())
for _ in range(T):
    N = int(input())
    graph = [[] for _ in range(N+1)]
    arr = list(map(int, input().split()))
    for i in range(1, N+1):
        graph[i].append(arr[i-1])    
    visited = [False] * (N+1)
    cnt = 0
    for i in range(1, N+1):
        if not visited[i]:
            bfs(i)
            cnt += 1
            visited[i] = True
    print(cnt)
    