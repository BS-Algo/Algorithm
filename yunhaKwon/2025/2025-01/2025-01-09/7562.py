from collections import deque

dx = [1, 2, 2, 1, -2, -1, -2, -1]
dy = [-2, -1, 1, 2, 1, 2, -1, -2]

def bfs(i, j):
    queue = deque()
    queue.append((i, j))
    arr[i][j] = 1

    while queue:
        x, y = queue.popleft()
        if x == end_x and y == end_y:
            return arr[x][y] - 1

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < I and 0 <= ny < I and not arr[nx][ny]:
                queue.append((nx, ny))
                arr[nx][ny] = arr[x][y] + 1


T = int(input())
for _ in range(T):
    I = int(input())
    arr = [[0] * I for _ in range(I)]
    start_x, start_y = map(int, input().split())
    end_x, end_y = map(int, input().split())

    ans = bfs(start_x, start_y)
    print(ans)
