N, M = map(int, input().split())
arr = list(map(int, input().split()))
start = min(arr)
end = min(arr) * M
result = 0
while start <= end:
    mid = (start + end) // 2
    cnt = 0

    for i in arr:
        cnt += (mid // i)

    if cnt < M:
        start = mid + 1
    else:
        result = mid
        end = mid - 1
print(result)
