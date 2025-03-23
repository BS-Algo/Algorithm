from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(start, end):
    queue = deque()
    queue.append((start, end))
    visited[start][end] = 1

    while queue:
        x, y = queue.popleft()

        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]

            if 0 <= nx < N and 0 <= ny < N and arr[nx][ny] == arr[x][y] and visited[nx][ny] == 0:
                visited[nx][ny] = visited[x][y] + 1
                queue.append((nx, ny))


N = int(input())
arr = [list(map(str, input())) for _ in range(N)]
visited = [[0] * (N+1) for _ in range(N)]
cnt = 0
for i in range(N):
    for j in range(N):
        for k in range(4):
            nx = i + dx[k]
            ny = j + dy[k]
            if 0 <= nx < N and 0 <= ny < N and arr[nx][ny] != arr[i][j] and visited[nx][ny] == 0:
                bfs(nx ,ny)
                cnt += 1

visited = [[0] * (N+1) for _ in range(N)]
cnt_2 = 0               
for i in range(N):
    for j in range(N):
        if arr[i][j] == 'G':
            arr[i][j] = 'R'

for i in range(N):
    for j in range(N):
        for k in range(4):
            nx = i + dx[k]
            ny = j + dy[k]
            if 0 <= nx < N and 0 <= ny < N and arr[nx][ny] != arr[i][j] and visited[nx][ny] == 0:
                bfs(nx ,ny)
                cnt_2 += 1
print(cnt, cnt_2)
        