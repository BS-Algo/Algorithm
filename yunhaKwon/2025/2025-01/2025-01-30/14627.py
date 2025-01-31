S, C = map(int, input().split())
green_onion = []
for _ in range(S):
    green_onion.append(int(input()))

start = 1
end = max(green_onion)

while start <= end:
    mid = (start + end) // 2
    cnt = 0
    for g in green_onion:
        cnt += (g // mid)

    if cnt >= C:
        start = mid + 1
    else:
        end = mid - 1

result = sum(green_onion) - (C * end)
print(result)