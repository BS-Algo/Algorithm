import sys
from collections import deque
input = sys.stdin.readline

for _ in range(int(input())):
    n, k = map(int, input().split())
    build_time = list(map(int, input().split()))
    graphs = [[] for _ in range(n+1)]
    degrees = [0] * (n+1)
    
    for _ in range(k):
        a, b = map(int, input().split())
        graphs[a].append(b)
        degrees[b] += 1
        
    w = int(input().rstrip())
    dq = deque()
    total_time = [0] * (n+1)
    for i in range(1, n+1):
        if degrees[i] == 0:
            dq.append(i)
            total_time[i] = build_time[i-1]
    
    while dq:
        cur_order = dq.popleft()
        
        for next_order in graphs[cur_order]:
            total_time[next_order] = max(total_time[next_order], total_time[cur_order] + build_time[next_order-1])
            degrees[next_order] -= 1
            
            if degrees[next_order] == 0:
                dq.append(next_order)
    print(total_time[w])