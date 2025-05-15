from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs():
    queue = deque()
    queue.append((0, 0))
    visited[0][0] = True
    melt = deque()

    while queue:
        x, y = queue.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] == False:
                visited[nx][ny] = True
                if arr[nx][ny] == 0:
                    queue.append((nx, ny))
                else:
                    melt.append((nx, ny))
    for a, b in melt:
        arr[a][b] = 0

    return len(melt)
hour = 1
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
cnt = 0
for i in range(N):
    for j in range(M):
         if arr[i][j] == 1:
             cnt += 1
while True:
    visited = [[False] * M  for _ in range(N)]
    melt_cnt = bfs()
    cnt -= melt_cnt
    if cnt == 0:
        print(hour)
        print(melt_cnt)
        break
    hour += 1