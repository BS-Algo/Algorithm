T = int(input())
for tc in range(T):
    a, b = map(int, input().split())
    if a % 10 != 0:
        a = a % 10
        if a == 1 or a == 5 or a == 6:
            print(a)
        elif a == 2 or a == 3 or a == 7 or a == 8:
            if b % 4 == 0:
                b = 4
            else:
                b = b % 4
            print((a**b) % 10)
        elif a == 4 or a == 9:
            if b % 2 == 0:
                b = 2
            else:
                b = b % 2
            print((a**b) % 10)
    else:
        print(10)