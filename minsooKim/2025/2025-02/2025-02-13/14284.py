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

n, m = map(int, input().split())
INF = 1e9
dist = [INF] * (n+1)
graph = [[] for _ in range(n+1)]
for _ in range(m):
    v1, v2, cost = map(int, input().split())
    graph[v1].append((v2, cost))
    graph[v2].append((v1, cost))
s, t = map(int, input().split())
dijkstra(1)
print(dist)

