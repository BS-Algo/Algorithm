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
                result_y[n[0]]= node                                           
                heapq.heappush(q, (new_cost, n[0]))

n = int(input())
m = int(input())
INF = 1e9
dist = [INF] * (n+1)
graph = [[] for _ in range(n+1)]
for _ in range(m):
    v1, v2, cost = map(int, input().split())
    graph[v1].append((v2, cost))
s, t = map(int, input().split())
result_y = [0] * (n+1)
dijkstra(s)
result = []
x = t
while x:
    result.append(x)
    x = result_y[x]
result = result[::-1]
print(dist[t])
print(len(result))
print(*result)




