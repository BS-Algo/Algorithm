from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs():
    queue = deque()
    queue.append((0, 0))
    visited[0][0] = True

    while queue:
        bx, by = queue.popleft()

        for a, b in switch[bx][by]:
            if room[a][b] == 0 and visited[a][b] == False:
                room[a][b] = 1

                for k in range(4):
                    nx = a + dx[k]
                    ny = b + dy[k]

                    if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] == True:
                        visited[a][b] = True
                        queue.append((a, b))

        for i in range(4):
            nx = bx + dx[i]
            ny = by + dy[i]

            if 0 <= nx < N and 0 <= ny < N:
                if room[nx][ny] == 1 and visited[nx][ny] == False:
                    visited[nx][ny] = True
                    queue.append((nx, ny))


N, M = map(int, input().split())
room = [[0] * N for _ in range(N)]
visited = [[False] * N for _ in range(N)]
room[0][0] = 1
# room = [[1, 0, 0], [0, 0 ,0], [0, 0, 0]]
# room[0][0] = 1
# a, b =  1, 2 room[0][1]
switch = [[[] for _ in range(N)] for _ in range(N)]
for _ in range(M):
    x, y, a, b = map(int, input().split())
    switch[x - 1][y - 1].append((a - 1, b - 1))
bfs()
cnt = 0
for i in range(N):
    for j in range(N):
        if room[i][j] == 1:
            cnt += 1
print(cnt)