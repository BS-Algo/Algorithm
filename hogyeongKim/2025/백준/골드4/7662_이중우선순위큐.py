from heapq import heappush, heappop
from collections import Counter
import sys
input = sys.stdin.readline

for _ in range(int(input())):
    k = int(input())
    inputs = []
    max_heap, min_heap = [], []
    cnt = Counter()
    for _ in range(k):
        cmd, n = input().split()
        n = int(n)
        if cmd == 'I':
            heappush(max_heap, -n)
            heappush(min_heap, n)
            cnt[n] += 1
        else:
            if n == 1:
                while max_heap and cnt[-max_heap[0]] == 0:
                    heappop(max_heap)

                if max_heap:
                    value = -heappop(max_heap)
                    cnt[value] -= 1
            elif n == -1:
                while min_heap and cnt[min_heap[0]] == 0:
                    heappop(min_heap)

                if min_heap:
                    value = heappop(min_heap)
                    cnt[value] -= 1

    while max_heap and cnt[-max_heap[0]] == 0:
        heappop(max_heap)
    while min_heap and cnt[min_heap[0]] == 0:
        heappop(min_heap)
        
    if max_heap and min_heap:
        print(-heappop(max_heap), heappop(min_heap))
    else:
        print('EMPTY')
        