n = int(input())
tickets = list(map(int, input().split()))
tickets = set(tickets)
for i in range(1, 2**31):
    if i not in tickets:
        print(i)
        break