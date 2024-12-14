import sys
import heapq
input = sys.stdin.readline

N = int(input())
min_heap = []
result = []
for _ in range(N):
    num = int(input())
    if num == 0:
        if min_heap:
            result.append(heapq.heappop(min_heap))
        else:
            result.append(0)
    else:
        heapq.heappush(min_heap, num)
for i in result:
    print(i)