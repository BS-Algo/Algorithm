import heapq
import sys
input = sys.stdin.readline

n, m, r = map(int, input().split())
items = [0] + list(map(int, input().split()))

graph = [[] for _ in range(n+1)]
for _ in range(r):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))
    graph[v].append((u, w))

def dijkstra(s):
    q = []
    heapq.heappush(q, (0, s))
    distance[s] = 0

    while q:
        d, now = heapq.heappop(q)
        if distance[now] < d:
            continue
        for v, w in graph[now]:
            cost = d + w
            if cost < distance[v]:
                distance[v] = cost
                heapq.heappush(q, (cost, v))


INF = int(1e9)
ans = []
for i in range(1, n+1):
    distance = [INF] * (n+1)
    dijkstra(i)

    tmp = 0
    for j in range(1, n+1):
        if distance[j] <= m:
            tmp += items[j]
    ans.append(tmp)

print(max(ans))