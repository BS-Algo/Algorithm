from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs(a, b, ch):
    queue = deque()
    queue.append((a, b))
    cnt = 1

    while queue:
        x, y = queue.popleft()
        visited[x][y] = 1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n and visited[nx][ny] != 1:
                if arr[nx][ny] == ch:
                    queue.append((nx, ny))
                    visited[nx][ny] = 1
                    cnt += 1
    return cnt**2

n, m = map(int, input().split())
arr = [list(input()) for _ in range(m)]

visited = [[0] * n for _ in range(m)]
sum_w = []
sum_b = []

for i in range(m):
    for j in range(n):
        if arr[i][j] == 'W' and visited[i][j] == 0:
            sum_w.append(bfs(i, j, 'W'))
        elif arr[i][j] == 'B' and visited[i][j] == 0:
            sum_b.append(bfs(i, j, 'B'))

print(sum(sum_w), sum(sum_b))