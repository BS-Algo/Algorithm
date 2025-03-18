from collections import deque
import sys
input = sys.stdin.readline

monkey_dx = [0, 0, -1, 1]
monkey_dy = [-1, 1, 0, 0]
horse_dx = [-2, -1, 1, 2, -2, -1, 1, 2]
horse_dy = [-1, -2, 2, 1, 1, 2, -2, -1]

def bfs(k):
    q = deque()
    q.append((0, 0, k))

    while q:
        x, y, horse_cnt = q.popleft()
        if x == h-1 and y == w-1: #도착점에 도착
            return visited[x][y][horse_cnt]

        if horse_cnt > 0:
            for i in range(8):
                nx = x + horse_dx[i]
                ny = y + horse_dy[i]
                if 0 <= nx < h and 0 <= ny < w:
                    if arr[nx][ny] != 1 and visited[nx][ny][horse_cnt-1] == 0:
                        visited[nx][ny][horse_cnt-1] = visited[x][y][horse_cnt] + 1
                        q.append((nx, ny, horse_cnt-1))


        for i in range(4):
            nx = x + monkey_dx[i]
            ny = y + monkey_dy[i]
            if 0 <= nx < h and 0 <= ny < w:
                if arr[nx][ny] != 1 and visited[nx][ny][horse_cnt] == 0:
                    visited[nx][ny][horse_cnt] = visited[x][y][horse_cnt] + 1
                    q.append((nx, ny, horse_cnt))


    return -1

k = int(input())
w, h = map(int, input().split())
arr = []
for _ in range(h):
    arr.append(list(map(int, input().split())))

visited = [[[0] * (k+1) for _ in range(w)] for _ in range(h)]
print(bfs(k))