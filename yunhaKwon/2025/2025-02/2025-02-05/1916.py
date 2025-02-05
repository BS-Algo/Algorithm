import sys
input = sys.stdin.readline

N = int(input())
M = int(input())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    u, v, w = map(int, input().split())

    # 같은 (u → v) 경로가 여러 개 있을 수 있으므로 최소 비용만 저장
    found = False
    for i in range(len(graph[u])):
        if graph[u][i][0] == v:  # 이미 존재하는 목적지라면
            graph[u][i][1] = min(graph[u][i][1], w)  # 최소 비용 저장
            found = True
            break
    if not found:
        graph[u].append([v, w])

start, end = map(int, input().split())

INF = int(1e9)
visited = [False] * (N+1) # 방문 표시용
distance = [INF] * (N+1) # start에서 다른 지점들까지의 최소 거리 배열

def get_smallest_node():
    min_val = INF
    idx = -1
    for i in range(1, N+1):
        if distance[i] < min_val and not visited[i]:
            min_val = distance[i]
            idx = i
    return idx

def dijkstra(start):
    distance[start] = 0
    for v, w in graph[start]:
        distance[v] = w

    for _ in range(N-1):
        now = get_smallest_node() # 출발점에서 갈 수 있는 노드 중 가장 거리가 짧은 노드 선택
        visited[now] = True

        for v, w in graph[now]:
            if distance[now] + w < distance[v]:
                distance[v] = distance[now] + w

# 출발지와 도착지가 같은 경우 처리
if start == end:
    print(0)
else:
    dijkstra(start)
    print(distance[end])
