T = int(input())
for _ in range(T):
    order = input()
    
    # 북, 동, 남, 서 (0, 1, 2, 3)
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    
    dir = 0
    x = 0
    y = 0

    min_x = max_x = x
    min_y = max_y = y 

    for c in order:
        if c == 'F':
            x += dx[dir]
            y += dy[dir]
        elif c == 'B':
            x -= dx[dir]
            y -= dy[dir]
        elif c == 'L':
            dir = (dir - 1) % 4
        elif c == 'R':
            dir = (dir + 1) % 4
    
        min_x = min(min_x, x)
        max_x = max(max_x, x)
        min_y = min(min_y, y)
        max_y = max(max_y, y)

    area = (max_x - min_x) * (max_y - min_y)
    print(area)

