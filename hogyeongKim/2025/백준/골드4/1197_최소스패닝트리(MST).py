import sys
from heapq import heappop, heappush
input = sys.stdin.readline

v, e = map(int, input().split())
graphs = [[] for _ in range(v+1)]

for i in range(e):
    a, b, w = map(int, input().split())
    graphs[a].append((w, b))
    graphs[b].append((w, a))


def prim():
    visited = [False] * (v+1)
    result = 0
    
    pq = []
    for weight, node in graphs[1]:
        heappush(pq, (weight, node))
    visited[1] = True
    cnt = 1
    
    while pq and cnt < v:
        
        cur_weight, cur_node = heappop(pq)
        
        if visited[cur_node]:
            continue
        
        else:
            visited[cur_node] = True
            cnt += 1
            result += cur_weight
        
        for next_weight, next_node in graphs[cur_node]:
            if not visited[next_node]:
                heappush(pq, (next_weight, next_node))
    return result

print(prim())
