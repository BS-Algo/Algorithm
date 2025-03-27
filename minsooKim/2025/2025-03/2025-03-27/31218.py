n, m, Q = map(int, input().split())
arr = [[0] * m for _ in range(n)]
cnt = n * m
for _ in range(Q):
    lst = list(map(int, input().split()))
    
    if lst[0] == 1:
        y, x, dy, dx = lst[3] -1, lst[4] -1, lst[1], lst[2]

        while 0 <= y < n and 0 <= x < m and arr[y][x] == 0:
            arr[y][x] = 1
            cnt -= 1
            y = y + dy
            x = x + dx
    elif lst[0] == 2:
        print(arr[lst[1]-1][lst[2]-1])
    else:
        print(cnt)