A, B = map(int, input().split())
arr = [[i] for i in range(11)]
lst = []
for i in range(1, 11):
    arr[i] = arr[i] * i
    for j in arr[i]:
        lst.append(j)
print(lst)
print(sum(lst[A-1:B]))
