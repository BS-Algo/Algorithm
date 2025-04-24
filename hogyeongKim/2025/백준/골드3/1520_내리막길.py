import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

dt = ((1, 0), (-1, 0), (0, 1), (0, -1))

m, n = map(int, input().split())

journey_map = [list(map(int, input().split())) for _ in range(m)] 
memo = [[-1] * n for _ in range(m)]

def dfs(x, y):
    if x == m-1 and y == n-1:
        return 1
    
    if memo[x][y] != -1:
        return memo[x][y]
    
    cnt = 0
    for dx, dy in dt:
        nx, ny = x + dx, y + dy
        if 0 <= nx < m and 0 <= ny < n:
            if journey_map[nx][ny] < journey_map[x][y]:
                cnt += dfs(nx, ny)
    
    memo[x][y] = cnt
    return memo[x][y]
    
dfs(0, 0)
print(memo[0][0])