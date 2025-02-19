T = int(input())
for _ in range(T):
    a = list(map(str, input().split()))
    for i in a:
        for j in range(len(i)):
            print(i[-(j+1)], end='')
        print(end=' ')