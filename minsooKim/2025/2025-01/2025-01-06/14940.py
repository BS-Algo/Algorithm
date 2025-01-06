from collections import deque

def bfs(a, b):
    queue = deque([(a, b)])    
    visited[a][b] = True    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, 1, -1]
    
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < n and 0 <= ny < m:
                if graph[nx][ny] == 1 and not visited[nx][ny]:
                    visited[nx][ny] = True
                    graph[nx][ny] = graph[x][y] + 1
                    queue.append((nx, ny))


n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]
# 가로가 m 세로가 n
for i in range(n): # 2 3 -> n = 2 m = 3. i = 0
    for j in range(m):
        if graph[i][j] == 2 and not visited[i][j]:
            visited[i][j] = True
            graph[i][j] = 0
            bfs(i, j)
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1 and not visited[i][j]:
            visited[i][j] = True
            graph[i][j] = -1

for i in graph:
    print(*i)
