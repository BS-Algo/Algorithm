import sys
input = sys.stdin.readline
from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs():
    q = deque()
    q.append((0, 0))
    visited[0][0] = 1

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
                if arr[nx][ny] >= 1:
                    arr[nx][ny] += 1
                else:
                    visited[nx][ny] = 1
                    q.append((nx, ny))

def melt_cheese():
    melt = 0 # 녹였는지 여부 판단하는 변수
    for i in range(n):
        for j in range(m):
            if arr[i][j] >= 3:
                arr[i][j] = 0
                melt = 1
            elif arr[i][j] == 2:
                arr[i][j] = 1

    return melt

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

hour = 0
while True:
    visited = [[0] * m for _ in range(n)]
    bfs()
    melt = melt_cheese()

    if melt:
        hour += 1
    else:
        print(hour)
        break
