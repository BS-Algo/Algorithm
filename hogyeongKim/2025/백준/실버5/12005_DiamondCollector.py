n, k = map(int, input().split())

jewels = [int(input()) for _ in range(n)]
jewels.sort()
max_cnt = 0

for i in range(n):
    cnt = 1
    for j in range(i+1, n):
        if jewels[j]-jewels[i] <= k:
            cnt += 1
        else:
            break
    max_cnt = max(cnt, max_cnt)
print(max_cnt)