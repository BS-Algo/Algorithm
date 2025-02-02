N, M = map(int, input().split())
time = list(map(int, input().split()))

start = min(time)
end = min(time) * M

while start <= end:
    mid = (start + end) // 2
    cnt = 0

    for i in range(N):
        cnt += (mid // time[i])

    if cnt < M:
        start = mid + 1
    else:
        end = mid - 1

print(start)