from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]



def add_walls(cnt):
    if cnt == 3:
        bfs()
        return

    for i in range(n):
        for j in range(m):
            if arr[i][j] == 0:
                arr[i][j] = 1
                add_walls(cnt + 1)
                arr[i][j] = 0

def bfs():
    visited = [[0] * m for _ in range(n)]
    queue = deque()

    for i in range(n):
        for j in range(m):
            if arr[i][j] == 2:
                queue.append((i, j))
                visited[i][j] = 1

            elif arr[i][j] == 1:
                visited[i][j] = 1

    while queue:
        x, y = queue.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 <= nx < n and 0 <= ny < m:
                if arr[nx][ny] == 0 and visited[nx][ny] == 0:
                    visited[nx][ny] = 1
                    queue.append((nx, ny))

    global ans
    cnt = 0

    for i in range(n):
        cnt += visited[i].count(0)

    ans = max(ans, cnt)

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
ans = 0
add_walls(0)
print(ans)