import heapq

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    dist[start] = 0

    while q:
        distance, node = heapq.heappop(q)
        if distance > dist[node]:
            continue
        for n in graph[node]:
            new_cost = n[1] + dist[node]
            if new_cost < dist[n[0]]:
                dist[n[0]] = new_cost
                heapq.heappush(q, (new_cost, n[0]))

N, M = map(int, input().split())
INF = 1e9
dist = [INF] * (N + 1)
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    A, B, C = map(int, input().split())
    graph[A].append((B, C))
    graph[B].append((A, C))
dijkstra(1)
print(dist[N])