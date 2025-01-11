from collections import deque

dx = [0, 0, -1, 1]
dy = [1, -1, 0 ,0]

def bfs(i, j):
    queue = deque()
    queue.append((i, j))
    visited[i][j] = 1
    cnt = 0

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
                if arr[nx][ny] == 'P':
                    cnt += 1
                    arr[nx][ny] = 'O'

                if arr[nx][ny] == 'O':
                    queue.append((nx, ny))
                    visited[nx][ny] = 1

    return cnt

N, M = map(int, input().split())
arr = [list(map(str, input())) for _ in range(N)]
visited = [[0] * M for _ in range(N)]

for i in range(N):
    for j in range(M):
        if arr[i][j] == 'I':
            ans = bfs(i, j)

if ans == 0:
    print('TT')
else:
    print(ans)