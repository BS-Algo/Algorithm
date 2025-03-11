import sys
import heapq

n, m = map(int, input().split())
time = list(map(int, input().split()))
time.sort(reverse=True) #소요시간 내림차순 정렬

heap = []

for t in time:
    if len(heap) < m:
        heapq.heappush(heap, t)
    else:
        tmp = heapq.heappop(heap)
        heapq.heappush(heap, tmp + t)

print(max(heap))