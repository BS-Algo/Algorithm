def check(x, y, visited):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if (nx, ny) in visited:
            return False
    return True

def dfs(visited, cnt):
    global ans
    if cnt >= ans:
        return
    if len(visited) == 15:
        ans = min(ans, cnt)

    else:
        for i in range(1, n-1):
            for j in range(1, n-1):
                if check(i, j, visited) and (i, j) not in visited:
                    tmp = [(i, j)]
                    tmp_cnt = garden[i][j]
                    for k in range(4):
                        nx = i + dx[k]
                        ny = j + dy[k]
                        tmp_cnt += garden[nx][ny]
                        tmp.append((nx, ny))
                    dfs(visited + tmp, cnt + tmp_cnt)


n = int(input())
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
res = []
ans = 99999

garden = []
for _ in range(n):
    garden.append(list(map(int, input().split())))

dfs([], 0)
print(ans)