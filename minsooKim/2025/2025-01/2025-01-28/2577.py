A = int(input())
B = int(input())
C = int(input())
Z = list(map(int, str(A*B*C)))
# Z = [1, 7 ~~]
for i in range(0, 10):
    cnt = 0
    for j in Z:
        if i == j:
            cnt += 1
    print(cnt)
