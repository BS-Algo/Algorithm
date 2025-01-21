from collections import deque

def bfs(si, sj):
    global area, maxarea
    queue = deque()
    queue.append((si, sj))
    visited[si][sj] = 1
    area += 1

    while queue:
        ci, cj = queue.popleft()
        for i in range(4):
            ni = ci + di[i]
            nj = cj + dj[i]
            if 0 <= ni < n and 0 <= nj < m and not visited[ni][nj] and arr[ni][nj] == 1:
                queue.append((ni,nj))
                visited[ni][nj] = 1
                area += 1


di = [0, 0, 1, -1]
dj = [1, -1, 0, 0]

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
visited = [[0]*m for _ in range(n)]

area = 0
maxarea = 0
numcnt = 0
for i in range(n):
    for j in range(m):
        if arr[i][j] == 1 and not visited[i][j]:
            bfs(i, j)
            maxarea = max(area, maxarea)
            area = 0
            numcnt += 1
print(numcnt)
print(maxarea)