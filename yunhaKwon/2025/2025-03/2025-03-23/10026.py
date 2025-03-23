from collections import deque
import sys
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(a, b):
    q = deque()
    q.append((a, b))
    visited[a][b] = 1

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and arr[nx][ny] == arr[x][y] and not visited[nx][ny]:
                visited[nx][ny] = 1
                q.append((nx, ny))


N = int(input())
arr = [list(input()) for _ in range(N)]
visited = [[0] * N for _ in range(N)]
res1 = 0
res2 = 0

#적록색약 x
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i, j)
            res1 += 1

visited = [[0] * N for _ in range(N)] #visited 배열 초기화
#적록색약 o
for i in range(N):
    for j in range(N):
        if arr[i][j] == 'R':
            arr[i][j] = 'G'

for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i, j)
            res2 += 1

print(res1, res2)
