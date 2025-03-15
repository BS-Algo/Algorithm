import sys
import heapq
input = sys.stdin.readline

n = int(input())
q = []

for i in range(n):
    nums = list(map(int, input().split()))

    if not q:
        for n in nums:
            heapq.heappush(q, n)

    else:
        for n in nums:
            if q[0] < n:
                heapq.heappush(q, n)
                heapq.heappop(q)

print(q[0])