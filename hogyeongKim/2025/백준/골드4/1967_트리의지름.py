# import sys
# sys.setrecursionlimit(10000)

# def dfs(node, parent, graph, dist):
#     max_dist = dist
#     farthest = node
    
#     for next_node, weight in graph[node]:
#         if next_node != parent:
#             cur_dist, cur_node = dfs(next_node, node, graph, dist + weight)
#             if cur_dist > max_dist:
#                 max_dist = cur_dist
#                 farthest = cur_node
    
#     return max_dist, farthest

# n = int(input())
# if n == 1:
#     print(0)
# else:
#     graph = [[] for _ in range(n+1)]
    
#     for _ in range(n-1):
#         a, b, w = map(int, input().split())
#         graph[a].append((b, w))
#         graph[b].append((a, w))
    
#     # 1. 임의의 점(1번)에서 가장 먼 점 찾기
#     _, farthest = dfs(1, -1, graph, 0)
    
#     # 2. 그 점에서 가장 먼 점까지의 거리가 트리의 지름
#     diameter, _ = dfs(farthest, -1, graph, 0)
    
#     print(diameter)

import sys
from heapq import heappush, heappop
input = sys.stdin.readline

n = int(input())
graphs = [[] for _ in range(n+1)]

for _ in range(n-1):
    a, b, w = map(int, input().split())
    graphs[a].append((w, b))
    graphs[b].append((w, a))
    
distance = [float('inf')] * (n+1)

def dijkstra(node):
    distance[node] = 0
    hq = [(distance[node], node)]
    
    while hq:
        cur_weight, cur_node = heappop(hq)
        
        if cur_weight > distance[cur_node]:
            continue
            
        for next_weight, next_node in graphs[cur_node]:
            new_dist = cur_weight + next_weight
            
            if new_dist <= distance[next_node]:
                distance[next_node] = new_dist
                heappush(hq, (new_dist, next_node))

dijkstra(1)
farthest_node = max(range(1, n+1), key=lambda x: distance[x])

distance = [float('inf')] * (n+1)
dijkstra(farthest_node)

distance[0] = 0
print(max(distance))