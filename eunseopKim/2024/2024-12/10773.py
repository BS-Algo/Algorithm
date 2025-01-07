K = int(input())
lst = []
for _ in range(K):
    num = int(input())
    if num == 0:
        lst.pop()
    else:
        lst.append(num)
print(sum(lst))