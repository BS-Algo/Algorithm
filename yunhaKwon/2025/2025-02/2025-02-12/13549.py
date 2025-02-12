import heapq

def dijkstra(n):
    mx = 100000
    INF = float('inf')
    dist = [INF] * (mx + 1)
    q = []

    heapq.heappush(q, (0, n))
    dist[n] = 0

    while q:
        cost, now = heapq.heappop(q)
        if now == k:
            return cost

        if 0 <= now * 2 <= mx and dist[now * 2] > cost:
            dist[now * 2] = cost
            heapq.heappush(q, (cost, now * 2))

        if 0 <= now + 1 <= mx and dist[now + 1] > cost + 1:
            dist[now + 1] = cost + 1
            heapq.heappush(q, (cost + 1, now + 1))

        if 0 <= now - 1 <= mx and dist[now - 1] > cost + 1:
            dist[now - 1] = cost + 1
            heapq.heappush(q, (cost + 1, now - 1))


n, k = map(int, input().split())
print(dijkstra(n))