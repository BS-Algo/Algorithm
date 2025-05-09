import sys
from heapq import heappop, heappush
input = sys.stdin.readline

v, e = map(int, input().split())
k = int(input().rstrip())
graphs = [[] for _ in range(v+1)]
distance = [float('inf')] * (v+1)

for i in range(e):
    a, b, w = map(int, input().split())
    graphs[a].append((w, b))


def dijkstra(node):
    global k, v, e
    
    pq = []
    distance[k] = 0
    
    heappush(pq, (0, node))
    
    while pq:
        cur_weight, cur_node = heappop(pq)
        
        if distance[cur_node] < cur_weight:
            continue
        
        for next_weight, next_node in graphs[cur_node]:
            new_weight = cur_weight + next_weight
            if new_weight < distance[next_node]:
                distance[next_node] = new_weight
                heappush(pq, (new_weight, next_node))

dijkstra(k)

for i in range(1, v+1):
    if distance[i] == float('inf'):
        print("INF")
    else:
        print(distance[i])