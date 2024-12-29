from collections import deque

def bfs(start, visited):
    queue = deque([start])
    visited[start[0]][start[1]] = True

    while queue:
        x, y = queue.popleft()
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0<= nx < N and 0 <= ny < M and graph[nx][ny] ==1 and visited[nx][ny] == False:
                visited[nx][ny] = True
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))

N, M = map(int, input().split())
graph = [list(map(int, input()))for _ in range(N)]
visited = [[False] * (M) for _ in range(N)]

bfs((0, 0), visited)
print(graph)
print(graph[N-1][M-1])