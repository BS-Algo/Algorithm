n, w, L = map(int, input().split())
trucks = list(map(int, input().split()))
queue = [0] * w
weight = 0
time = 0
while queue:
    num = queue.pop(0)
    weight -= num
    if trucks:
        if weight + trucks[0] <= L:
            weight += trucks[0]
            queue.append(trucks[0])
            trucks.pop(0)
        else:
            queue.append(0)
    time += 1
print(time)