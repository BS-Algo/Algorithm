import heapq

N = int(input())
q = []
for _ in range(N):
    x = int(input())
    if x != 0:
        heapq.heappush(q, (abs(x), x))        
    else:
        if len(q) == 0:
            print(0)
        else:
            print(heapq.heappop(q)[1])
