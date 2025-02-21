import sys
input = sys.stdin.readline

n = int(input())

di = {}
lst = []
for _ in range(n):
    a, b = input().strip().split('.')
    if b in di:
        di[b] += 1

    else:
        di[b] = 1
        lst.append(b)

# print(di)
# print(lst)

lst.sort()
for i in lst:
    print(i, di[i])