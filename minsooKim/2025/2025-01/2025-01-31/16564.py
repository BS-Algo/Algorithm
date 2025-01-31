N, K = map(int, input().split())
arr = []
for _ in range(N):
    arr.append(int(input()))
start = min(arr)
end = min(arr) + K
result = 0
while start <= end:
    mid = (start + end) // 2
    cnt = 0
    for i in arr:
        if mid > i:
            cnt += (mid-i)

    if cnt <= K :
        start = mid + 1
        result = mid
    else:
        end = mid - 1
print(result)



