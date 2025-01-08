N = int(input())
lst = list(map(int, input().split()))
M = int(input())
lst2 = list(map(int, input().split()))

hash = {}
for i in lst:
    hash[i] = hash.setdefault(i, 0) + 1
for i in lst2:
    print(hash.setdefault(i, 0), end = ' ')