ma = 0

for _ in range(int(input())) :
    a, d, g = map(int, input().split())
    if a == d + g :
        va = a * (d + g) * 2
    else :
        va = a * (d + g)
    ma = max(va, ma)

print(ma)
