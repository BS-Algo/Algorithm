import heapq

T = int(input())
for _ in range(T):
    k = int(input())
    q = []
    for _ in range(k):
        word, num = input().split()
        num = int(num)

        if word == 'I':
            heapq.heappush(q, num)
        elif word == 'D':
            if q:
                if num == -1:
                    heapq.heappop(q)
                else:
                    max_num = heapq.nlargest(1, q)[0]
                    q.remove(max_num)
                    heapq.heapify(q)
            else:
                continue
    if q:
        print(heapq.nlargest(1, q)[0], q[0])
    else:
        print("EMPTY")