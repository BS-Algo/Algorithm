M, N = map(int, input().split())
arr = list(map(int, input().split()))
start = 1
end = max(arr)
result = 0

while start <= end:
    mid = (start + end) // 2
    rope = mid
    cnt = 0
    for i in arr:
        cnt += i // rope
            
    if cnt < M :
        end = mid - 1
    else:
        result = mid
        start = mid + 1
print(result)
