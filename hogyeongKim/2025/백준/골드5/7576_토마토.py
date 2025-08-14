import sys
from collections import deque
input = sys.stdin.readline
dt = ((0, 1), (1, 0), (-1, 0), (0, -1))

m, n = map(int, input().split())

tomatoes = [list(map(int, input().split())) for _ in range(n)]

check = True

for x in range(n):
    if 0 in tomatoes[x]:
        check = False
        break
q = deque([])
if not check:
    cnt = 0
    for x in range(n):
        for y in range(m):
            if tomatoes[x][y] == 1:
                q.append((x, y))
    while q:
        cnt += 1
        for _ in range(len(q)):
            sx, sy = q.popleft()
            for dx, dy in dt:
                nx, ny = sx+dx, sy+dy
                if 0 <= nx <= n-1 and 0 <= ny <= m-1 and tomatoes[nx][ny] == 0:
                    tomatoes[nx][ny] = 1
                    q.append((nx, ny))
    

    for x in range(n):
        if 0 in tomatoes[x]:
            print(-1)
            exit()
    else:
        print(cnt-1)
                
else:
    print(0)
