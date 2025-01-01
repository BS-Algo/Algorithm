from collections import deque

def bfs(a, b, visited):
    queue = deque([(a, b)])
    visited[a][b] = True
    num = 1
    while queue:
        x, y = queue.popleft()
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < n and 0 <= ny < m:
                if arr[nx][ny] == 1 and not visited[nx][ny]:
                    num += 1
                    queue.append((nx, ny))
                    visited[nx][ny] = True
    result.append(num)                    


n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]
cnt = 0
result = []
for i in range(n):
    for j in range(m):
        if arr[i][j] == 1 and not visited[i][j]:
            bfs(i, j, visited)
            cnt += 1
print(cnt)
if len(result) == 0:
    print(0)
else:
    print(max(result))
