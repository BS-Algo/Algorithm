N = int(input())
queue = []
for _ in range(N):
    name, number = map(str, input().split())
    number = int(number)
    queue.append((name, number))
while len(queue) > 1:
    X = queue[0][1] # X = 3
    queue.pop(0)
    for _ in range(X-1):
        num = queue.pop(0)
        queue.append(num)
    queue.pop(0)
print(queue[0][0])

