N = int(input())

start = 1
end = N

target = end
while True:
    mid = (start + end) // 2
    if mid ** 2 == target:
        print(mid)
        break
    elif mid ** 2 > target:
        end = mid - 1
    else:
        start = mid + 1