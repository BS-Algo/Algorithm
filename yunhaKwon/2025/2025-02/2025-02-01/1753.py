import sys
input = sys.stdin.readline

V, E = map(int, input().split())  #정점, 간선
K = int(input())  #시작정점 번호

INF = float('inf')
graph = [[] for _ in range(V+1)]  #인접 리스트
dist = [INF] * (V+1)  #거리 리스트
visited = [False] * (V+1)  #방문여부 체크

for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))  #u -> v 가중치 w

dist[K] = 0

#방문하지 않은 정점 중 최단 거리 노드 찾기
def shortest():
    mn = INF
    index = -1
    for i in range(1, V+1):
        if not visited[i] and dist[i] < mn:
            mn = dist[i]
            index = i
    return index

for _ in range(V):
    now = shortest()  #방문하지 않은 정점 중 최단 거리 정점 선택
    if now == -1:
        break
    visited[now] = True  #방문 체크

    for v, w in graph[now]:  #현재 노드에서 갈 수 있는 모든 정점 확인
        if dist[now] + w < dist[v]:  #더 짧은 거리로 갱신
            dist[v] = dist[now] + w

for i in range(1, V+1):
    if dist[i] != INF:
        print(dist[i])
    else:
        print('INF')