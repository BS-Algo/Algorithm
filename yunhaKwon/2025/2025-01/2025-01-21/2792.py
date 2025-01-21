N, M = map(int, input().split())
jewerly = list(int(input()) for _ in range(M))

start = 1
end = max(jewerly)
ans = 0

while start <= end:
    mid = (start + end) // 2
    cnt = 0
    for i in range(M):
        cnt += jewerly[i] // mid
        if jewerly[i] % mid != 0:
            cnt += 1

    if cnt > N:
        start = mid + 1
    else:
        end = mid - 1
        ans = mid

print(ans)