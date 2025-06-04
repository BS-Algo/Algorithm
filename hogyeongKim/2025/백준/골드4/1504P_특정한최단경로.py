import sys
from heapq import heappush, heappop
input = sys.stdin.readline

v, e = map(int, input().split())
graphs = [[] for _ in range(v+1)]

for _ in range(e):
    a, b, w = map(int, input().split())
    graphs[a].append((w, b))
    graphs[b].append((w, a))
    
v1, v2 = map(int, input().split())

def dijkstra(node, vertex):
    distance = [sys.maxsize] * (vertex+1)
    distance[node] = 0
    hq = []
    heappush(hq, (distance[node], node))
    
    while hq:
        cur_weight, cur_node = heappop(hq)
        
        if cur_weight > distance[cur_node]:
            continue
        
        for next_weight, next_node in graphs[cur_node]:
            new_weight = next_weight + cur_weight
            
            if new_weight > distance[next_node]:
                continue
            
            distance[next_node] = new_weight
            heappush(hq, (new_weight, next_node))
    return distance
    
distance_1 = dijkstra(1, v)
distance_v1 = dijkstra(v1, v)
distance_v2 = dijkstra(v2, v)

path1 = distance_1[v1] + distance_v1[v2] + distance_v2[v]
path2 = distance_1[v2] + distance_v2[v1] + distance_v1[v]

result = min(path1, path2)

if result >= sys.maxsize:
    print(-1)
else:
    print(result)