K, N = map(int, input().split())
arr = [int(input()) for _ in range(K)]

start = 1
end = max(arr)

while start <= end:
    mid = (start + end) // 2
    num = 0

    for i in arr:
        num += i // mid

    if num >= N:
        start = mid + 1
    else:
        end = mid - 1

print(end)