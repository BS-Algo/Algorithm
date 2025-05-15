import sys
input = sys.stdin.readline
from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs():
    q = deque()
    q.append((0, 0))
    melt = deque()

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
                visited[nx][ny] = 1
                if arr[nx][ny] == 0:
                    q.append((nx, ny))
                elif arr[nx][ny] == 1:
                    melt.append((nx, ny))

    for a, b in melt:
        arr[a][b] = 0

    return len(melt) #녹인 치즈 개수 반환

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
total_cnt = 0 #처음 치즈 전체 개수
for i in range(n):
    for j in range(m):
        if arr[i][j] == 1:
            total_cnt += 1

hour = 1
while True:
    visited = [[0] * m for _ in range(n)]
    melt_cheese = bfs()
    total_cnt -= melt_cheese #bfs탐색 한 번 돌릴 때마다 녹은 치즈 개수만큼 빼줌
    if total_cnt == 0: #치즈가 다 녹은 경우
        print(hour)
        print(melt_cheese)
        break
    hour += 1