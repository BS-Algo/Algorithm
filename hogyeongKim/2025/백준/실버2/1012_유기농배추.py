from collections import deque
import sys
input = sys.stdin.readline

for _ in range(int(input())):

    dt = ((1, 0), (0, 1), (-1, 0), (0, -1))
    n, m, k = map(int, input().split())

    farm = [[0] * m for _ in range(n)]
    for _ in range(k):
        x, y = map(int, input().split())
        farm[x][y] = 1

    def bfs(sx, sy):
        q = deque([(sx, sy)])

        while q:
            x, y = q.popleft()
            
            for dx, dy in dt:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < m and farm[nx][ny] == 1:
                    farm[nx][ny] = 0
                    q.append((nx, ny))
                
    cnt = 0
    for i in range(n):
        for j in range(m):
            if farm[i][j] == 1:
                bfs(i, j)
                cnt += 1

    print(cnt)