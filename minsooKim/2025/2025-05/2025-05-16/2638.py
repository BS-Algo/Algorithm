from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs():
    queue = deque()
    queue.append((0, 0))
    visited[0][0] = True
    
    while queue:
        x, y = queue.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if  0 <= nx < N and 0 <= ny < M and visited[nx][ny] == False:
                if arr[nx][ny] >= 1:
                    arr[nx][ny] += 1
                else:
                    visited[nx][ny] = True
                    queue.append((nx, ny))

def melt():
    melt = 0
    for i in range(N):
        for j in range(M):
            if arr[i][j] >= 3:
                arr[i][j] = 0
                melt = 1
            elif arr[i][j] == 2:
                arr[i][j] = 1
    return melt

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
hour = 0

while True:
    visited = [[False] * M for _ in range(N)]
    bfs()
    melt_cnt = melt()

    if melt_cnt:
        hour += 1
    else:
        print(hour)
        break