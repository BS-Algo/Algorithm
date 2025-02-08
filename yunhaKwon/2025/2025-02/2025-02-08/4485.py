import sys
import heapq
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dijkstra():
    queue = []
    heapq.heappush(queue, (0, 0, graph[0][0]))
    distance[0][0] = 0

    while queue:
        x, y, cost = heapq.heappop(queue)

        if x == n - 1 and y == n - 1:
            print(f'Problem {cnt}: {distance[x][y]}')
            break

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n:
                new_cost = cost + graph[nx][ny]

                if new_cost < distance[nx][ny]:
                    distance[nx][ny] = new_cost
                    heapq.heappush(queue, (nx, ny, new_cost))

cnt = 1
while True:
    n = int(input())
    if n == 0:
        break

    INF = int(1e9)
    graph = [list(map(int, input().split())) for _ in range(n)]
    distance = [[INF] * n for _ in range(n)]

    dijkstra()
    cnt += 1