# 그래프 + 최소비용 = 다익스트라
import sys
from heapq import heappop, heappush
input = sys.stdin.readline

n = int(input())
m = int(input())

graphs = [[] for _ in range(n+1)]

for i in range(m):
    s, e, w = map(int, input().split())
    graphs[s].append([e, w])
 
start, end = map(int, input().split())
distance = [sys.maxsize] * (n+1)

def dijkstra(node):
    pq = []
    distance[node] = 0
    
    heappush(pq, (0, node))
    
    while pq:
        cur_dist, cur_node = heappop(pq)
        
        if cur_node == end:
            return
        
        if distance[cur_node] < cur_dist:
            continue
        
        for next_node, next_dist in graphs[cur_node]:
            new_dist = cur_dist + next_dist
            
            if new_dist >= distance[next_node]:
                continue
            distance[next_node] = new_dist
            heappush(pq, (new_dist, next_node))

dijkstra(start)
print(distance[end])