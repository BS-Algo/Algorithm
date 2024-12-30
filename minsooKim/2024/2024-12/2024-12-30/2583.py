from collections import deque

def bfs(start, visited):
    queue = deque([start])
    visited[start[0]][start[1]] = True
    num = 1

    while queue:
        node = queue.popleft()
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]
        for i in range(4):
            nx = dx[i] + node[0]
            ny = dy[i] + node[1]

            if 0 <= nx < M and 0 <= ny < N:
                if graph[nx][ny] == 1 and visited[nx][ny] == False:
                    visited[nx][ny] = True
                    queue.append((nx, ny))
                    num += 1
    result.append(num)

M, N, K = map(int, input().split())
graph = [[1] * N for _ in range(M)]
for a in range(K):
    start_x, start_y, end_x, end_y = map(int, input().split())
    # 0 2 4 4
    new_s_x = M - end_y
    # 1
    new_s_y = start_x
    # 0
    new_e_x = M - start_y - 1
    # 2
    new_e_y = end_x - 1
    # 3
    for i in range(new_s_x, new_e_x + 1):
        # i = 1, 2
        for j in range(new_s_y, new_e_y + 1):
            # j = 0 1 2 3
            graph[i][j] = 0
visited = [[False] * N for _ in range(M)]
cnt = 0
result = []
for i in range(M):
    for j in range(N):
        if graph[i][j] == 1 and visited[i][j] == False:
            bfs((i, j), visited)
            cnt += 1
print(cnt)
result.sort()
print(*result)


