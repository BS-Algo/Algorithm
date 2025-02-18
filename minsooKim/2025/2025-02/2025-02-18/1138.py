N = int(input())
arr = list(map(int, input().split()))
lst = list(zip(range(1, N+1), arr))
lst.sort(key=lambda x:-x[1])
print(lst)
for i in range(1, N-1):
    cnt = 0
    for j in range(i+1, N):
        if lst[i][0] < lst[j][0]:
            cnt += 1
        if lst[i][1] == cnt:
            continue
        else:
            lst[i], lst[j] = lst[j], lst[i]
print(lst)

