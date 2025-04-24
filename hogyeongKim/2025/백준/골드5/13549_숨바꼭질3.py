import sys
from heapq import heappush, heappop

n, k = map(int, input().split())
mx_range = max(n, k) * 2
graphs = [[(1, 1), (0, 0)]] + [[(1, i+1), (1, i-1), (0, 2*i)] for i in range(1, mx_range+1)]
distance = [sys.maxsize] * (mx_range*2+1)
distance[n] = 0

def dijkstra(node):
    pq = []
    heappush(pq, node)
    
    while pq:
        cur_dist, cur_node = heappop(pq)
        
        if cur_node == k:
            return
        
        if cur_dist > distance[cur_node]:
            continue
        
        for next_dist, next_node in graphs[cur_node]:
            new_dist = next_dist + cur_dist
            
            if new_dist >= distance[next_node]:
                continue
            
            if next_node < 0 or next_node > mx_range:
                continue
            
            distance[next_node] = new_dist
            heappush(pq, (new_dist, next_node))
    
dijkstra((0, n))
print(distance[k])