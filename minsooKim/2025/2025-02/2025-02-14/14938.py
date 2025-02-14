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

n, m, r = map(int, input().split())
item = [0] + list(map(int, input().split()))
graph = [[] for _ in range(n+1)]

for _ in range(r):
    v1, v2, cost = map(int, input().split())
    graph[v1].append((v2, cost))
    graph[v2].append((v1, cost))

answer = []

for i in range(1, n+1):
    INF = 1e9
    dist = [INF] * (n+1)
    result = 0
    dijkstra(i)
    for j in range(1, n+1):
        if dist[j] <= m:
            result += item[j]
    answer.append(result)
print(max(answer))