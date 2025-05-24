n = int(input())
orders = list(map(int, input().split()))

orders.sort()
total = 0
time = 0
for order in orders:
    time += order
    total += time

print(total)