import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

dt = ((1, 0), (-1, 0), (0, 1), (0, -1))

n = int(input())

area = [list(map(int, input().split())) for _ in range(n)]
height = max(map(max, area))

def dfs(x, y):
    global rain

    for dx, dy in dt:
        nx, ny = x+dx, y+dy
        if 0 <= nx < n and 0 <= ny < n:
            if not visited[nx][ny] and area[nx][ny] > rain:
                visited[nx][ny] = True
                dfs(nx, ny)

mx_cnt = 0
for rain in range(height+1):
    visited = [[False] * n for _ in range(n)]
    cnt = 0
    for x in range(n):
        for y in range(n):
            if not visited[x][y] and area[x][y] > rain:
                visited[x][y] = True
                dfs(x, y)
                cnt += 1
    mx_cnt = max(mx_cnt, cnt)

print(mx_cnt)