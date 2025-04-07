n = int(input())
if n == 0:
    print(0)
    exit()

arr = [int(input()) for _ in range(n)]
num = round(n * 0.15 + 1e-7)
arr.sort()
lst = arr[num:n - num]
if not lst:
    print(0)
else:
    avg_lst = round(sum(lst) / len(lst))
    print(avg_lst)
