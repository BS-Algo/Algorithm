N = int(input())
time = 0
k = 1

while N > 0:
    if N >= k:
        N -= k
        time += 1
        k += 1
    else:
        k = 1
print(time)