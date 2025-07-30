n = int(input())
tickets = list(map(int, input().split()))

for i in range(1, 2**31):
    if i not in tickets:
        print(i)
        break