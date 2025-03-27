import sys
input = sys.stdin.readline

n, m, q = map(int, input().strip().split())
lawn = [[0] * m for _ in range(n)]
cnt = n * m

for _ in range(q):
    query = list(map(int, input().strip().split()))
    if query[0] == 1:
        dy, dx, y, x = query[1], query[2], query[3]-1, query[4]-1
        while True:
            if y < 0 or y >= n or x < 0 or x >= m:
                break
            if lawn[y][x] == 1:
                break
            lawn[y][x] = 1
            cnt -= 1
            y += dy
            x += dx
    elif query[0] == 2:
        print(lawn[query[1]-1][query[2]-1])
    elif query[0] == 3:
        print(cnt)