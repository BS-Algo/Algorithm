N, K = map(int, input().split())
arr = []
for _ in range(N):
    arr.append(int(input()))
start = 0
end = max(arr)
result = 0
while start <= end:
    mid = (start + end) // 2
    cnt = 0
    for i in arr:
        cnt += (i // mid)
    
    if cnt < K:
        end = mid - 1
    else:
        result = mid
        start = mid + 1
print(result)