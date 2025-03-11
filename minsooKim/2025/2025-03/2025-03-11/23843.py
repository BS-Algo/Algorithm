import heapq

N, M = map(int, input().split())
time = list(map(int, input().split()))
time.sort(reverse=True)
q = []
for i in range(N):
    if len(q) < M:
        heapq.heappush(q, time[i])
    else:
        num = heapq.heappop(q)
        heapq.heappush(q, time[i] + num)
print(max(q))