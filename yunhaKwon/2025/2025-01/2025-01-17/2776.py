T = int(input())
for _ in range(T):
    N = int(input())
    diary1 = set(map(int, input().split()))
    M = int(input())
    diary2 = list(map(int, input().split()))

    for i in diary2:
        if i in diary1:
            print(1)
        else:
            print(0)