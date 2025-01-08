lst = []
for _ in range(3):
    a, b, c = map(str, input().split())
    lst.append([a, b, c[0]])
for i in lst:
    i[1] = int(i[1]) % 100
lst.sort(key= lambda x: (x[1]))
for i in lst:
    print(i[1], end='')
    i[0] = int(i[0])
lst.sort(key= lambda x: (x[0]), reverse=True)
print()
for i in lst:
    print(i[2], end='')