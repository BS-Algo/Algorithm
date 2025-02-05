import heapq

N = int(input())
M = int(input())
INF = 1e9
dist = [INF] * (N+1)
graph = [[] for _ in range(N+1)]

for _ in range(M):
    v1, v2, cost = map(int, input().split())
    graph[v1].append((v2, cost))

start, end = map(int, input().split())

def dijkstara(start):
    q = []
    heapq.heappush(q, (0, start))
    dist[start] = 0

    while q:
        print(q)
        distance, node = heapq.heappop(q)
        print(q)
        if distance > dist[node]:
            continue

        for n in graph[node]:
            new_cost = n[1] + dist[node]

            if new_cost < dist[n[0]]:
                dist[n[0]] = new_cost
                heapq.heappush(q, (new_cost, n[0]))
dijkstara(start)
print(dist[end])