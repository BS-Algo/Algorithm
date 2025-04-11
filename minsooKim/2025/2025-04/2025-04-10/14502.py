from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def makingwall(cnt):
    if cnt == 3:
        bfs()
        return
    
    for i in range(N):
        for j in range(M):
            if arr[i][j] == 0:
                arr[i][j] = 1
                makingwall(cnt+1)
                arr[i][j] = 0


def bfs():
    global answer
    visited = [[0] * M for _ in range(N)]
    queue = deque()
    for i in range(N):
        for j in range(M):
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

            if 0 <= nx < N and 0 <= ny < M and arr[nx][ny] == 0 and visited[nx][ny] == 0:
                visited[nx][ny] = 1
                queue.append((nx,ny))
    safe = 0
    for i in range(N):
        for j in range(M):
            if visited[i][j] == 0:
                safe += 1

    answer = max(answer, safe)

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
answer = 0
makingwall(0)
print(answer)