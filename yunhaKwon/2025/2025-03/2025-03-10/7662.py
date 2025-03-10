import sys
import heapq
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    mn_heap = []
    mx_heap = []

    k = int(input())
    check = [True] * k

    for i in range(k):
        s, num = input().split()
        num = int(num)

        if s == 'I':
            heapq.heappush(mn_heap, (num, i))
            heapq.heappush(mx_heap, (-num, i))

        elif s == 'D':
            if num == -1:
                if mn_heap:
                    check[heapq.heappop(mn_heap)[1]] = False
            elif num == 1:
                if mx_heap:
                    check[heapq.heappop(mx_heap)[1]] = False

        while mn_heap and check[mn_heap[0][1]] == False:
            heapq.heappop(mn_heap)
        while mx_heap and check[mx_heap[0][1]] == False:
            heapq.heappop(mx_heap)

    if mn_heap == [] and mx_heap == []:
        print("EMPTY")
    else:
        print(-mx_heap[0][0], mn_heap[0][0])