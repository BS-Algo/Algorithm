x = int(input())
m = int(input())
lst = []
for n in range(1, m):
    if (x * n) % m == 1:
        lst.append(n)
if len(lst) == 1:
    print(lst[0])
else:
    print('No such integer exists.')