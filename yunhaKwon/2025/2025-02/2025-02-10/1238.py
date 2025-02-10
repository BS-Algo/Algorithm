import heapq

def dijkstra(s):
    INF = float('inf')
    distance = [INF] * (N+1)
    distance[s] = 0

    q = []
    heapq.heappush(q, (0, s))

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] >= dist:
            for end, val in graph[now]:
                if dist + val < distance[end]:
                    distance[end] = dist + val
                    heapq.heappush(q, (dist + val, end))

    return distance

N, M, X = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    u, v, w = map(int, input().split())
    graph[u].append([v, w])

ans = dijkstra(X)
ans[0] = 0
for i in range(1, N+1):
    if i != X:
        res = dijkstra(i)
        ans[i] += res[X]

print(max(ans))