for _ in range(int(input())) :
    N, *D = map(int, input().split())
    res = False
    for i in range(1, N) :
        if (D[i-1] << 1) > D[i] :
            break
    else : res = True
    print("Denominations:", *D)
    print(["Bad coin denominations!", "Good coin denominations!"][res], '\n')