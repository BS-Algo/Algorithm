import sys
from collections import deque
input = sys.stdin.readline
dt = ((0, 1), (1, 0), (-1, 0), (0, -1))

n = int(input())
rgb = [list(input().rstrip()) for _ in range(n)]
t_visited = [[False] * n for _ in range(n)]
f_visited = [[False] * n for _ in range(n)]
t_cnt, f_cnt = 0, 0

for i in range(n):
    for j in range(n):
        if not f_visited[i][j]:
            q = deque([(i, j)])
            f_visited[i][j] = True
            f_cnt += 1
            while q:
                x, y = q.popleft()
                color = rgb[x][y]
                for dx, dy in dt:
                    nx, ny = x+dx, y+dy
                    if 0 <= nx < n and 0 <= ny < n and not f_visited[nx][ny] and rgb[nx][ny] == color:
                        f_visited[nx][ny] = True
                        q.append((nx, ny))
        if not t_visited[i][j]:
            q = deque([(i, j)])
            t_visited[i][j] = True
            t_cnt += 1
            while q:
                x, y = q.popleft()
                color = rgb[x][y]
                if color == 'B':
                    for dx, dy in dt:
                        nx, ny = x+dx, y+dy
                        if 0 <= nx < n and 0 <= ny < n and not t_visited[nx][ny] and rgb[nx][ny] == color:
                            t_visited[nx][ny] = True
                            q.append((nx, ny))
                elif color != 'B':
                    for dx, dy in dt:
                        nx, ny = x+dx, y+dy
                        if 0 <= nx < n and 0 <= ny < n and not t_visited[nx][ny] and rgb[nx][ny] != 'B':
                            t_visited[nx][ny] = True
                            q.append((nx, ny))

print(f_cnt, t_cnt)