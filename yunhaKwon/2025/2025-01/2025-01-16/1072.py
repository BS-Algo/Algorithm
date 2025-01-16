X, Y = map(int, input().split())
Z = (100 * Y) // X

start = 1
end = X
ans = 0

if Z >= 99:
    print(-1)

else:
    while start <= end:
        mid = (start + end) // 2
        if (100 * (Y + mid) // (X + mid)) > Z:
            ans = mid
            end = mid - 1
        else:
            start = mid + 1

    print(ans)