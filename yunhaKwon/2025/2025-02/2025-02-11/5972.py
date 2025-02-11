import heapq
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
INF = float('inf')
distance = [INF] * (n+1)
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

def dijkstra(s):
    q = []
    distance[s] = 0
    heapq.heappush(q, (0, s))

    while q:
        d, v = heapq.heappop(q)
        if distance[v] < d:
            continue
        for next in graph[v]:
            cost = d + next[1]
            if cost < distance[next[0]]:
                distance[next[0]] = cost
                heapq.heappush(q, (cost, next[0]))

    return distance[n]

print(dijkstra(1))

