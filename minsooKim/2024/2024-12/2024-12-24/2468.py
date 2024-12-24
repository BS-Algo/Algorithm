from collections import deque

def bfs(a, b, num):
    queue = deque()
    queue.append((a, b))
    visited[a][b] = True

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            if 0 <= nx < N and 0 <= ny < N:
                if graph[nx][ny] > num and visited[nx][ny] == 0:
                    visited[nx][ny] = True
                    queue.append((nx, ny))

N = int(input())
graph = []
max_num = 0
dx = [1, -1, 0, 0]
dy=  [0, 0, 1, -1]
for i in range(N):
    arr = list(map(int, input().split()))
    graph.append(arr)

    for j in arr:
        if j > max_num:
            max_num = j       
result = []
for i in range(max_num):
    visited = [[False] * N for _ in range(N)]
    cnt = 0

    for j in range(N):
        for k in range(N):
            if graph[j][k] > i and visited[j][k] == 0:
                bfs(j, k, i)
                cnt += 1

    result.append(cnt)

print(max(result))