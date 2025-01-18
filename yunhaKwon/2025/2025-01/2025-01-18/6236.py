N, M = map(int, input().split())
money = list(int(input()) for _ in range(N))

start = max(money)
end = sum(money)

while start <= end:
    mid = (start + end) // 2
    cnt = 1
    charge = mid

    for i in range(N):
        if charge < money[i]:
            charge = mid
            cnt += 1
        charge -= money[i]

    if cnt > M:
        start = mid + 1
    else:
        end = mid - 1

print(mid)