import sys
input = sys.stdin.readline

a, b = map(int, input().split())
cnt = 1

while b > a:
    if b % 2 == 0:
        b //= 2
    else:
        if str(b)[-1] != '1':
            break
        if b >= 10:
            b //= 10
        else:
            break
    cnt += 1

if b == a:
    print(cnt)
else:
    print(-1)