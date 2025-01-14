N = int(input())
arr = list(map(int, input().split()))
M = int(input())

start = 0
end = max(arr)
result = 0

while start <= end:
    mid = (start + end) // 2
    total = 0

    for i in arr:
        total += min(i, mid)

    if total <= M:
        result = mid
        start = mid + 1
    else:
        end = mid - 1

print(result)