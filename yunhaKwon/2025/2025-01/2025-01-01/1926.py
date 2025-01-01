from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    visited[x][y] = 1
    cnt = 1

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] != 1 and pic[nx][ny] == 1:
                visited[nx][ny] = 1
                cnt += 1
                queue.append((nx, ny))

    return cnt

n, m = map(int, input().split())
pic = [list(map(int, input().split())) for _ in range(n)]
visited = [[0] * m for _ in range(n)]

pic_num = 0
max_width = 0

for i in range(n):
    for j in range(m):
        if pic[i][j] == 1 and visited[i][j] == 0:
            pic_num += 1
            max_width = max(max_width, bfs(i, j))

print(pic_num)
print(max_width)