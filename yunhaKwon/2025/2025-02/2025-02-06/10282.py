from heapq import heappop, heappush

t = int(input())
for _ in range(t):
    n, d, c = map(int, input().split())
    graph = [[] for _ in range(n+1)]

    for _ in range(d):
        a, b, s = map(int, input().split())
        graph[b].append([a, s])

    INF = int(1e9)
    dist = [INF] * (n+1)
    visited = [0] * (n+1)
    heap = []

    dist[c] = 0
    heappush(heap, [0, c])

    while heap:
        cost, node = heappop(heap)
        if visited[node] == 1:
            continue
        visited[node] = 1

        for next, d in graph[node]:
            if not visited[next]:
                if dist[next] > cost + d:
                    dist[next] = cost + d
                    heappush(heap, [dist[next], next])


    cnt, time = 0, 0
    for c in range(1, n+1):
        if visited[c]:
            cnt += 1
            time = max(time, dist[c])

    print(cnt, time)