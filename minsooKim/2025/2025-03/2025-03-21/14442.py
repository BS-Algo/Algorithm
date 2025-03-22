from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

def bfs():
    queue = deque()
    queue.append((0, 0, K))
    visited[0][0][K] = 0

    while queue:
        x, y, wall_left = queue.popleft()

        if x == N-1 and y == M-1:
            return visited[x][y][wall_left]

        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]

            if 0 <= nx < N and 0 <= ny < M and arr[nx][ny] == 0 and visited[nx][ny][wall_left] == -1:
                visited[nx][ny][wall_left] = visited[x][y][wall_left] + 1
                queue.append((nx, ny, wall_left))                

        if wall_left > 0:
            for k in range(4):
                nx = x + dx[k]
                ny = y + dy[k]

                if 0 <= nx < N and 0 <= ny < M and visited[nx][ny][wall_left-1] == -1:
                    visited[nx][ny][wall_left-1] = visited[x][y][wall_left] + 1
                    queue.append((nx, ny, wall_left-1))
    return -1           


N, M, K = map(int, input().split())
arr = [list(map(int, input())) for _ in range(N)]
visited = [[[-1] * (K+1) for _ in range(M)] for _ in range(N)]
a = bfs()
if a != -1:
    print(a+1)
else:
    print(-1)



