from collections import deque
def bfs(start, num):
    visited = [False] * (N+1)
    queue = deque([(start, num)])
    visited[start] = True
    result = []

    while queue:
        n, cnt = queue.popleft()
        if cnt == K:
            result.append(n)
            continue
        for i in graph[n]:
            if not visited[i]:
                queue.append((i, cnt+1))
                visited[i] = True                
                
    if len(result) == 0:
        print(-1)
    else:
        result.sort()
        for a in result:
            print(a)   

N, M, K, X = map(int, input().split())
# N = 도시의 개수, M = 도로의 개수, 거리정보 K, 출발 도시 번호 X
graph = [[] for _ in range(N+1)]
for _ in range(M):
    A, B = map(int,input().split())
    graph[A].append(B)
bfs(X, 0)
