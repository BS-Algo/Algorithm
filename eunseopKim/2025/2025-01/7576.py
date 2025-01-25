from collections import deque

di = [0, 0, 1, -1]
dj = [1, -1, 0, 0]
M, N = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[0]*M for _ in range(N)]
day = 0

def bfs():
    while q:
        ci, cj = q.popleft()
        for i in range(4):
            ni = ci + di[i]
            nj = cj + dj[i]
            if 0 <= ni < N and 0 <= nj < M and visited[ni][nj] == 0 and arr[ni][nj] == 0:
                arr[ni][nj] = arr[ci][cj] + 1
                q.append((ni, nj))
                visited[ni][nj] = 1

q = deque()
for i in range(N):
    for j in range(M):
        if arr[i][j] > 0:
            q.append((i, j))
            visited[i][j] = 1
            day += 1

bfs()

if min(value for row in arr for value in row if value >= 0) == 0:
    print(-1)
else:
    print(max(map(max, arr))-1)