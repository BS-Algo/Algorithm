from collections import deque

def bfs(start, end, visited):
    queue = deque()
    queue.append((start, end))
    visited[start][end] = True

    while queue:
        x,y = queue.popleft()
        for i in range(8):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < h and 0 <= ny < w:
                if graph[nx][ny] == 1  and visited[nx][ny] == False:
                    queue.append((nx, ny))
                    visited[nx][ny] = True

dx = [-1, 1, 0, 0, 1, 1, -1 ,-1]
dy = [0, 0, 1, -1, 1, -1, 1, -1]

while True:
    w, h = map(int, input().split())
    visited = [[False] * (w) for _ in range(h)]
    cnt = 0
    if w == 0 and h == 0:
        break
    graph = []
    for _ in range(h):        
        arr = list(map(int, input().split()))
        graph.append(arr)

    for i in range(h):
        for j in range(w):      # w= 5, h = 4 j = 0 1 2 3 4 h = 0 1 2 3
            if graph[i][j] == 1 and visited[i][j] == False:
                bfs(i, j, visited)
                cnt += 1
    print(cnt)

