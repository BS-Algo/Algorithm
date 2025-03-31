def dfs(x, y):
    if arr[x][y] == 1:
        return 1
    for k in range(4):
        if arr[x+dx[k]][y+dy[k]] == 1:
            return 1
    return 0

def visit(x, y, num):
    cost = graph[x][y]
    arr[x][y] = num

    for k in range(4):
        arr[x+dx[k]][y+dy[k]] = num
        cost += graph[x+dx[k]][y+dy[k]]
    return cost

min_result = 5000

def last(xp, yp, result, depth):
    global min_result

    if depth == 3:
        min_result = min(result, min_result)
        return
    
    for x in range(xp, N-1):
        for y in range(yp, N-1):
            if dfs(x, y) == 1:
                continue
            real_cost = visit(x, y, 1)
            last(x, y, result+real_cost, depth+1)
            visit(x, y, 0)
        yp = 1

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
arr = [[0] * N for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

last(1, 1, 0, 0)
print(min_result)
    