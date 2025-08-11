import sys
from collections import deque
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
dt = ((1, 0), (-1, 0), (0, 1), (0, -1))

# 빙산의 각 부분 높이 양의 정수, 나머지는 0(2차원 배열)
n, m = map(int, input().split())
iceberg = [list(map(int, input().split())) for _ in range(n)]
    
def check_iceberg():
    visited = [[False]*m for _ in range(n)]
    cnt = 0
    for x in range(1, n-1):
        for y in range(1, m-1):
            if iceberg[x][y] and not visited[x][y]:
                q = deque([(x, y)])
                visited[x][y] = True
                while q:
                    cur_x, cur_y = q.popleft()
                    for dx, dy in dt:
                        nx, ny = cur_x + dx, cur_y + dy
                        if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and iceberg[nx][ny] > 0:
                            visited[nx][ny] = True
                            q.append((nx, ny))
                cnt += 1
    return cnt

if check_iceberg() >= 2:
    print(0)
    exit(0)

time = 0
while True:
    time += 1
    iceberg_pos = []
    for x in range(1, n-1):
        for y in range(1, m-1):
            if iceberg[x][y]:
                iceberg_pos.append((x, y))

    if not iceberg_pos:
        print(0)
        break
    
    destroyed_iceberg = {}
    for x, y in iceberg_pos:
        cnt = 0
        for dx, dy in dt:
            nx, ny = x+dx, y+dy
            if iceberg[nx][ny] == 0:
                cnt += 1
        destroyed_iceberg[(x, y)] = cnt

    for x, y in iceberg_pos:
            iceberg[x][y] = max(iceberg[x][y] - destroyed_iceberg[(x, y)], 0)
    
    checker = check_iceberg()
    if checker >= 2:
        print(time)
        break
    elif  checker == 0:
        print(0)
        break