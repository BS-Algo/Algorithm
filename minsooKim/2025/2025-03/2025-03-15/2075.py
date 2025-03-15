import heapq

N = int(input())
q = []
for _ in range(N):
    for i in list(map(int, input().split())):
        heapq.heappush(q, i)
        
        if len(q) > N:
            heapq.heappop(q)

for i in range(N):
    if i == N-1:
        print(heapq.heappop(q))

