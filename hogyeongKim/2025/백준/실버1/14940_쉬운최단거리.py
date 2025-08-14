import sys
from collections import deque
input = sys.stdin.readline
dt = ((0, 1), (1, 0), (-1, 0), (0, -1))

n, m = map(int, input().split())

world_map = [list(map(int, input().split())) for _ in range(n)]
load_map = [[0] * m for _ in range(n)]

for i in range(n):
    for j in range(m):
        if world_map[i][j] == 2:
            sx, sy = i, j

q = deque([(sx, sy)])
while q:
    x, y = q.popleft()
    for dx, dy in dt:
        nx, ny = x+dx, y+dy
        if 0 <= nx < n and 0 <= ny < m and world_map[nx][ny] == 1 and load_map[nx][ny] == 0:
            load_map[nx][ny] = load_map[x][y] + 1
            q.append((nx, ny))

for i in range(n):
    for j in range(m):
        if load_map[i][j] == 0:
            if world_map[i][j] == 1:
                load_map[i][j] = -1

for row in load_map:
    print(*row)