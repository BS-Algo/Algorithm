import heapq
import sys
input = sys.stdin.readline

def dijkstra(s):
    q = []
    heapq.heappush(q, (0, s))
    while q:
        d, now = heapq.heappop(q)
        if distance[now] < d:
            continue
        for v, w in graph[now]:
            cost = d + w
            if cost < distance[v]:
                distance[v] = cost
                heapq.heappush(q, (cost, v))

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
INF = float('inf')
distance = [INF] * (n+1)

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

s, t = map(int, input().split())
dijkstra(s)
print(distance[t])