n = int(input())
distance = list(map(int, input().split()))
cost = list(map(int, input().split()))

result = distance[0] * cost[0]
min_cost = cost[0]

for i in range(1, n-1):
    if min_cost > cost[i]:
        min_cost = cost[i]
    result += min_cost * distance[i]

print(result)