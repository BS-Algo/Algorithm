import sys
from collections import deque
input = sys.stdin.readline

dt = ((0, 0, 1), (0, 1, 0), (0, -1, 0), (0, 0, -1), (1, 0, 0), (-1, 0, 0))

m, n, h = map(int, input().split())

tomatoes = [[list(map(int, input().split())) for _ in range(n)] for _ in range(h)]

check = True

for z in range(h):
    for x in range(n):
        if 0 in tomatoes[z][x]:
            check = False
            break
q = deque([])
if not check:
    cnt = 0
    for z in range(h):
        for x in range(n):
            for y in range(m):
                if tomatoes[z][x][y] == 1:
                    q.append((z, x, y))
    while q:
        cnt += 1
        for _ in range(len(q)):
            sz, sx, sy = q.popleft()
            for dz, dx, dy in dt:
                nz, nx, ny = sz+dz, sx+dx, sy+dy
                if 0 <= nz <= h-1 and 0 <= nx <= n-1 and 0 <= ny <= m-1 and tomatoes[nz][nx][ny] == 0:
                    tomatoes[nz][nx][ny] = 1
                    q.append((nz, nx, ny))
    
    for z in range(h):
        for x in range(n):
            if 0 in tomatoes[z][x]:
                print(-1)
                exit()
    else:
        print(cnt-1)
                
else:
    print(0)
