import heapq

def dijkstra(a, b):
    q = []
    heapq.heappush(q, (graph[a][b], a, b))
    dist[a][b] = graph[a][b]

    while q:
        distance, start, end = heapq.heappop(q)
        if distance > dist[start][end]:
            continue
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]
        for k in range(4):
            nx = start + dx[k]
            ny = end + dy[k]            
            if 0 <= nx < N and 0 <= ny <N:
                new_cost = graph[nx][ny] + distance
                if new_cost < dist[nx][ny]:
                    dist[nx][ny] = new_cost
                    heapq.heappush(q, (new_cost, nx, ny))
while True:
    N = int(input())
    if N == 0:
        break
    graph = [list(map(int, input().split())) for _ in range(N)]
    INF = 1e9
    dist = [[INF] * (N) for _ in range(N)]
    dijkstra(0, 0)
    print(dist[N-1][N-1])


    

