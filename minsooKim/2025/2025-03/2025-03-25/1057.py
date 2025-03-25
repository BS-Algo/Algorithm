N, K, M = map(int, input().split())
cnt = 0
while K != M:
    K -= K // 2
    M -= M // 2
    cnt += 1
if cnt == 0:
    print(-1)
else:
    print(cnt)


    