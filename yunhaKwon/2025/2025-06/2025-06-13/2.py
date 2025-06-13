from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs():
    q = deque()
    q.append((0, 0))
    visited[0][0] = True
    cnt = 0

    while q:
        x, y = q.popleft()
        if x == n-1 and y == m-1:
            return cnt

        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]

            if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == False and maze[nx][ny] == 0:
                visited[nx][ny] = True
                q.append((nx, ny))

            elif 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == False and maze[nx][ny] == 1:
                cnt += 1
                maze[nx][ny] = 0
                visited[nx][ny] = True
                q.append((nx, ny))

m, n = map(int, input().split())
maze = [list(map(int, input())) for _ in range(n)]

visited = [[False] * m for _ in range(n)]
print(bfs())