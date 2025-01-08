from collections import deque

def bfs(start):
    queue = deque([(start)])
    visited[start[0]][start[1]] = True
    cnt = 1
    result = []
    
    while queue:
        x, y = queue.popleft()
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]

        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny))
                cnt += 1
    return cnt

N, M, K = map(int, input().split())
graph = [[0] * M for _ in range(N)]
for _ in range(K):
    r, c = map(int, input().split())
    graph[r-1][c-1] = 1
visited = [[False] * M for _ in range(N)]
result = []
for i in range(N):
    for j in range(M):
        if graph[i][j] == 1 and not visited[i][j]:
            visited[i][j] = True
            result.append(bfs((i, j)))
print(max(result))


