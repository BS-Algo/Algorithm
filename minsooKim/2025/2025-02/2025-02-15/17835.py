import heapq

def dijkstra():
    q = []
    dist = [INF] * (N+1)

    for start in interview:
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
    return dist    

N, M, K = map(int, input().split())
INF = 10**9
graph = [[] for _ in range(N+1)]
for _ in range(M):
    v1, v2, cost = map(int, input().split())
    graph[v2].append((v1, cost))
interview = list(map(int, input().split()))

dist = dijkstra()
max_nm = -1
max_mm = float('inf')
for i in range(1, N+1):
    if dist[i] == INF:
        continue
    if dist[i] > max_nm:
        max_nm = dist[i]
        max_mm = i
    elif dist[i] == max_nm and i < max_mm:
        max_mm = i
print(max_mm)
print(max_nm)