import heapq

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    dist[start] = 0

    while q:
        distance, node = heapq.heappop(q)
        # 0, 2
        if distance > dist[node]:
            continue

        for n in graph[node]:
            # n = (1, 5) n[0] = 1, n[1] = 5
            new_cost = n[1] + dist[node]
            
            if new_cost < dist[n[0]]:
                dist[n[0]] = new_cost
                heapq.heappush(q, (new_cost, n[0]))

T = int(input())
for _ in range(T):
    n, d, c = map(int, input().split())
    INF = 1e9
    dist = [INF] * (n + 1)
    graph = [[] for _ in range(n + 1)]
    for _ in range(d):
        a, b, s = map(int, input().split())
        graph[b].append((a, s))    

    dijkstra(c)
    cnt = 0
    max_nm = 0
    for i in dist:
        if i != INF:
            cnt += 1
            if i > max_nm:
                max_nm = i
    
    print(cnt, max_nm)
                