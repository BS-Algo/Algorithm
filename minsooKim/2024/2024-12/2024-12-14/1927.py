import sys
import heapq
input = sys.stdin.readline

N = int(input())
max_heap = []
result = []
for _ in range(N):
    num = int(input())
    if num == 0:
        if max_heap:
            result.append(-heapq.heappop(max_heap))
        else:
            result.append(0)
    else:
        heapq.heappush(max_heap, -num)
for i in result:
    print(i)
