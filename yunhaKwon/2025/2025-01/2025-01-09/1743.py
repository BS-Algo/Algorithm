from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(i, j):
    queue = deque()
    queue.append((i, j))
    visited[i][j] = 1
    cnt = 1

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and arr[nx][ny] == 1:
                queue.append((nx, ny))
                visited[nx][ny] = 1
                cnt += 1

    return cnt

N, M, K = map(int, input().split())
arr = [[0] * M for _ in range(N)]
for _ in range(K):
    r, c = map(int, input().split())
    arr[r-1][c-1] = 1

visited = [[0] * M for _ in range(N)]
ans = 0
for i in range(N):
    for j in range(M):
        if arr[i][j] == 1 and not visited[i][j]:
            ans = max(ans, bfs(i, j))

print(ans)