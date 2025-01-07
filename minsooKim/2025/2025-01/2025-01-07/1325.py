from collections import deque

def bfs(start):
    queue = deque([(start)])
    visited = [0] * (N+1)
    visited[start] =  1
    cnt = 1

    while queue:
        node = queue.popleft()
        for i in graph[node]:
            if not visited[i]:
                visited[i] = 1
                queue.append(i)
                cnt += 1
    return cnt      

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    A, B = map(int, input().split())    
    graph[B].append(A)

max_count = 0
result = []

for i in range(1, N+1):
    cnt = bfs(i)
    if cnt > max_count:
        max_count = cnt
        result = [i]
    elif cnt == max_count:
        result.append(i)
print(*sorted(result))
