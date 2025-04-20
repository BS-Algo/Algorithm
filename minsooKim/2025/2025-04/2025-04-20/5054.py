T = int(input())
for _ in range(T):
    n = int(input())
    store = list(map(int, input().split()))
    store.sort()
    cnt = 0
    for i in range(1, n):
        cnt += store[i] - store[i-1]
    print(cnt)