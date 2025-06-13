from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs():
    queue = deque()
    queue.append((0, 0))
    visited[0][0] = 0

    while queue:
        x, y = queue.popleft()

        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]

            if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] == -1:
                if arr[nx][ny] == 0:
                    visited[nx][ny] = visited[x][y]
                    queue.appendleft((nx, ny))

                elif arr[nx][ny] == 1:
                    visited[nx][ny] = visited[x][y] + 1
                    queue.append((nx, ny))
    return visited


M, N = map(int, input().split())
arr = [list(map(int, input())) for _ in range(N)]
visited = [[-1] * M for _ in range(N)]
lst = bfs()
print(lst)