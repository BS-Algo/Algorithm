import heapq

def dijkstra(start):
    INF = 1e9
    dist = [INF] * (N + 1)
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
    return dist

N, M, X = map(int, input().split())

graph = [[] for _ in range(N + 1)]
for _ in range(M):
    v1, v2, cost = map(int, input().split())
    graph[v1].append((v2, cost))    
answer = dijkstra(X)
lst = []
for i in range(1, N+1):
    result = dijkstra(i)
    lst.append(answer[i] + result[X])
print(lst)
    
