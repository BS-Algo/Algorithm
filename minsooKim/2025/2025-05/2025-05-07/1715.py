import heapq

N = int(input())
q= []

if N == 1:
    print(0)
    exit

for _ in range(N):
    card = int(input())
    heapq.heappush(q, card)

result = 0

while True:
    a = heapq.heappop(q)
    b = heapq.heappop(q)

    result += (a + b)
    if len(q) == 0:
        break

    heapq.heappush(q, a+b)
print(result)
