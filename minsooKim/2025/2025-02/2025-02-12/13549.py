import heapq

def dijkstra(n):
    
    q = []

    heapq.heappush(q, (0, n))
    dist[n] = 0

    while q:
        # 0, 5
        cost, now = heapq.heappop(q)
        if now == k:
            return cost

        if 0 <= now * 2 < mx and dist[now * 2] > cost:
            dist[now * 2] = cost
            heapq.heappush(q, (cost, now * 2))

        if 0 <= now + 1 < mx and dist[now + 1] > cost:
            dist[now + 1] = cost + 1
            heapq.heappush(q, (cost + 1, now + 1))

        if 0 <= now - 1 < mx and dist[now - 1] > cost:
            dist[now - 1] = cost + 1
            heapq.heappush(q, (cost + 1, now - 1))


n, k = map(int, input().split())
mx = 100001
INF = 1e9
dist = [INF] * mx
print(dijkstra(n))

 