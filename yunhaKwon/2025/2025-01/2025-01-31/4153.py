while True:
    a, b, c = map(int, input().split())
    arr = []
    arr.append(a)
    arr.append(b)
    arr.append(c)
    arr.sort()

    if a == b == c == 0:
        break

    if (arr[0] ** 2) + (arr[1] ** 2) == (arr[2] ** 2):
        print("right")
    else:
        print("wrong")