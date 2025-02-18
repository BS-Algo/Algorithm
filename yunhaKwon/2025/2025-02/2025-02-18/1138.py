n = int(input())
h = list(map(int, input().split()))

ans = [0] * n
for i in range(1, n+1):
    s = h[i-1]
    cnt = 0
    for j in range(n):
        if ans[j] == 0:
            if cnt == s:
                ans[j] = i
                break
            else:
                cnt += 1

print(*ans)