T = int(input())
for _ in range(T):
    N = int(input())
    arr = list(map(int, input().split()))
    lst = arr[::-1]
    print(lst)
    cnt = 0
    max_num = lst[0]
    for i in range(1, N):
        if lst[i] > max_num:
            max_num = lst[i]
        else:
            cnt += max_num - lst[i]
    print(cnt)
        

