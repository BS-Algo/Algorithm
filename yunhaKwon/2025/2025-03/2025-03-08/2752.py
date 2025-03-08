lst = []
a, b, c = list(map(int, input().split()))
lst.append(a)
lst.append(b)
lst.append(c)

print(*sorted(lst))