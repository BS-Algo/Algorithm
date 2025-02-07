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

N, D = map(int, input().split())
INF = 1e9
dist = [INF] * (D+11)
graph = [[] for _ in range(D+11)]
for _ in range(N):
    v1, v2, cost = map(int, input().split())
    if v2 <= D:
        graph[v1].append((v2, cost))
for i in range(D):
    graph[i].append((i+1, 1))

dijkstra(0)
print(dist[D])