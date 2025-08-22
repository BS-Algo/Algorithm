import sys
input = sys.stdin.readline
dt = ((0, 1), (1, 0), (-1, 0), (0, -1))
# 별도의 모양 체크 필요
exception = [
        [(0, 0), (0, 1), (0, 2), (1, 1)],  # ㅗ
        [(0, 0), (0, 1), (0, 2), (-1, 1)], # ㅜ
        [(0, 0), (1, 0), (2, 0), (1, 1)],  # ㅏ
        [(0, 0), (1, 0), (2, 0), (1, -1)]  # ㅓ
    ]

n, m = map(int, input().split())

polyomino = [list(map(int, input().split())) for _ in range(n)]
max_total = 0

def exception_valid(x, y):
    global max_total
    for row in exception:
        total = 0
        valid = True
        for dx, dy in row:
            nx, ny = x+dx, y+dy
            if 0 <= nx < n and 0 <= ny < m:
                total += polyomino[nx][ny]
            else:
                valid = False
                break
        if valid:
            max_total = max(max_total, total)

def dfs(x, y, total, cnt):
    global max_total, n, m

    if cnt == 4:
        max_total = max(max_total, total)
        return

    for dx, dy in dt:
        nx, ny = x+dx, y+dy
        if 0 <= nx < n and 0 <= ny < m:
            if not visited[nx][ny]:
                visited[nx][ny] = True
                dfs(nx, ny, total+polyomino[nx][ny], cnt+1)
                visited[nx][ny] = False

visited = [[False] * m for _ in range(n)]
for i in range(n):
    for j in range(m):   
        visited[i][j] = True
        dfs(i, j, polyomino[i][j], 1)
        visited[i][j] = False
        exception_valid(i, j)

print(max_total)