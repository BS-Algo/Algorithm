from collections import deque

def bfs(a, b):
    queue = deque([(a, b)])
    visited[a][b] = True
    cnt = 0

    while queue:
        x, y = queue.popleft()

        if graph[x][y] == "P":
            cnt += 1

        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]

        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
                if graph[nx][ny] in ["O", "P"]:
                    visited[nx][ny] = True
                    queue.append((nx, ny))
    if cnt >= 1:
        print(cnt)
    else:
        print("TT")                
                 

N, M = map(int, input().split())
arr = [list(map(str, input())) for _ in range(N)]
print(arr)
graph = [[] for _ in range(N)]
visited = [[False] * M for _ in range(N)]
for i in range(N):
    for j in arr[i]:
        graph[i].append(j)
for i in range(N):
    for j in range(M):
        if graph[i][j] == "I" and not visited[i][j]:
            bfs(i, j)