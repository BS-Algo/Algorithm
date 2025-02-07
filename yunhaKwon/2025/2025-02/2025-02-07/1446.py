import heapq
import sys
input = sys.stdin.readline

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)

        if dist > distance[now]:
            continue

        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))


N, D = map(int, input().split())
graph = [[] for _ in range(D+1)]
INF = int(1e9)
distance = [INF] * (D+1)

for i in range(D):
    graph[i].append((i+1, 1))

for _ in range(N):
    u, v, w = map(int, input().split())
    if v > D:
        continue
    graph[u].append((v, w))

dijkstra(0)
print(distance[D])