n = int(input())
for _ in range(n) :
    c, p = map(int, input().split())
    print(c, p)
    print(c*p-(c-1)*2)