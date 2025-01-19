M, N = map(int, input().split())
snack = list(map(int, input().split()))

start = 1
end = max(snack)
result = 0

while start <= end:
    mid = (start + end) // 2
    cnt = 0

    for i in snack:
        cnt += i // mid

    if cnt >= M:
        result = max(result, mid)
        start = mid + 1
    else:
        end = mid - 1

print(result)