T = int(input())
com = [input() for _ in range(T)]

# 북 서 남 동
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]

for c in com:
    dir = 0 # 북0 서1 남2 동3
    min_x, min_y, max_x, max_y = 0, 0, 0, 0

    x, y = 0, 0

    for i in c:
        if i == "F":
            x += dx[dir]
            y += dy[dir]
        elif i == "B":
            x -= dx[dir]
            y -= dy[dir]
        elif i == "L":
            if dir == 3:
                dir = 0
            else:
                dir += 1
        elif i == "R":
            if dir == 0:
                dir = 3
            else:
                dir -= 1

        min_x, min_y = min(min_x, x), min(min_y, y)
        max_x, max_y = max(max_x, x), max(max_y, y)

    print((max_x - min_x) * (max_y - min_y))