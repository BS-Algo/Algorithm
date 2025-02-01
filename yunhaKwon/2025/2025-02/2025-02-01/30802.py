n = int(input())
sizes = list(map(int,input().split()))
t,p = map(int,input().split())

cnt = 0
for s in sizes:
    if s == 0:
        continue
    elif s % t == 0:
        cnt += s // t
    else:
        cnt += s // t + 1

print(cnt)
print(n // p, n % p)