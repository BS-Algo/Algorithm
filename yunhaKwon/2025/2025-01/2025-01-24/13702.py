N, K = map(int, input().split())
arr = []
for _ in range(N):
    arr.append(int(input()))

start = 1
end = max(arr)

while start <= end:
    cnt = 0
    mid = (start + end) // 2

    for i in arr:
        cnt += i // mid

    if cnt >= K:
        result = mid
        start = mid + 1
    else:
        end = mid - 1

print(result)