import heapq
import sys
input = sys.stdin.readline

def dijkstra(s):
    distance[s] = 0
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
                prev[v] = now

    return distance

n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

start, end = map(int, input().split())
INF = float('inf')
distance = [INF] * (n+1)
prev = [0] * (n+1)
result = dijkstra(start)

print(result[end])

path = []
node = end
while node:
    path.append(node)
    node = prev[node]

print(len(path))
path.reverse()
print(*path)
print(graph)