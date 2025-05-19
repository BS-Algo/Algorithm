T = int(input())
for _ in range(T):
    arr = list(map(int, input().split()))
    lst = []
    for i in range(7):
        if arr[i] % 2 == 0:
            lst.append(arr[i])
    print(sum(lst), min(lst))
