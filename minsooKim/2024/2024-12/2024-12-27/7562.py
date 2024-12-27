from collections import deque

dx = [-2, -1, 1, 2, 2, 1, -1, -2]
dy = [-1, -2, -2, -1, 1, 2, 2, 1]

def bfs(l, start, target):
    visited = [[False] * l for _ in range(l)]
    queue = deque([(start[0], start[1], 0)])
    visited[start[0]][start[1]] = True

    while queue:
        x, y, moves_count = queue.popleft()
        
        if (x, y) == target:
            return moves_count
        
        for i in range(8):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < l and 0 <= ny < l and visited[nx][ny] == False:
                queue.append((nx, ny, moves_count+1))
                visited[nx][ny] = True
    return -1

T = int(input())
for _ in range(T):
    l = int(input())
    c_x, c_y = map(int, input().split())
    n_x, n_y = map(int, input().split())

    print(bfs(l, (c_x, c_y), (n_x, n_y)))
