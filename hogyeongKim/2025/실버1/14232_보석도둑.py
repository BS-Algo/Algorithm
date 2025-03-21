N = int(input())

num_lst = []

for i in range(2, int(N**0.5) + 1):
    while N % i == 0:
        num_lst.append(i)
        N //= i
if N != 1:
    num_lst.append(N)
print(len(num_lst))
num_lst.sort()
print(*num_lst)