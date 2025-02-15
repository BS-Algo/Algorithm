import sys
import heapq
n, m, k = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
for i in range(m):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[v].append([u, w])

locs = list(map(int, sys.stdin.readline().split()))

def dijkstra():
    q = []
    for l in locs:
        heapq.heappush(q, [0, l])
        distance[l] = 0

    while q:
        cost, now = heapq.heappop(q)
        if distance[now] < cost:
            continue
        for v, w in graph[now]:
            dist = cost + w
            if dist < distance[v]:
                distance[v] = dist
                heapq.heappush(q, [dist, v])



INF = float('inf')
distance = [INF] * (n+1)
dijkstra()

max_start, max_cost = 0, 0
for i in range(len(distance)):
    if distance[i] > max_cost and distance[i] != INF:
        max_start, max_cost = i, distance[i]
print(max_start)
print(max_cost)