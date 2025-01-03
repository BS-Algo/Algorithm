from collections import deque

def bfs(start, team, visited):
    queue = deque([start])
    visited[start[0]][start[1]] = True
    cnt = 1
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            if 0 <= nx < M and 0 <= ny < N and not visited[nx][ny] and graph[nx][ny] == team:
                visited[nx][ny] = True
                queue.append((nx, ny))
                cnt += 1
    return cnt

N, M = map(int, input().split())
graph = [list(input().strip()) for _ in range(M)]
visited = [[False] * M for _ in range(M)]
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

white_p = 0
blue_p = 0

for i in range(N):
    for j in range(M):
        if not visited[i][j]:
            if graph[i][j] == "W":
                white_p += bfs((i, j), "W", visited) ** 2
            elif graph[i][j] == "B":
                blue_p += bfs((i, j), "B", visited) ** 2
print(white_p, blue_p)

