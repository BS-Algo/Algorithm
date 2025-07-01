dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y, num):
    if len(num) == 6:
        res.append(num)
        return

    for k in range(4):
        nx = x + dx[k]
        ny = y + dy[k]
        if 0 <= nx < 5 and 0 <= ny < 5:
            dfs(nx, ny, num + arr[nx][ny])


arr = [list(map(str, input().split())) for _ in range(5)]
res = []
for i in range(5):
    for j in range(5):
        dfs(i, j, arr[i][j])

print(len(set(res)))