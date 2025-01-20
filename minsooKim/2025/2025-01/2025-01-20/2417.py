N = int(input())
start = 0
end = N
result = 0
while start <= end:
    mid = (start + end) // 2
    if mid **2 < N:
        start = mid + 1
    else:
        result = mid
        end = mid -1

print(result)