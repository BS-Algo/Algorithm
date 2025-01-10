import sys
input = sys.stdin.readline
N = int(input())
dir = {}
cnt = 0
for _ in range(N):
    book = input().rstrip()
    dir[book] = dir.setdefault(book, 0) + 1

lst = []
for i in dir:
    if dir[i] == max(dir.values()):
        lst.append(i)

lst.sort()
print(lst[0])