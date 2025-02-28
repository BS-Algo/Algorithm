lst = []
for _ in range(9):
    lst.append(int(input()))
lst.sort()
# print(lst)
for i in lst:
    for j in lst:
        if i == j:
            continue
        if sum(lst) - i - j == 100:
            lst.remove(i)
            lst.remove(j)
            for k in lst:
                print(k)