# from math import gcd

def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a

a, b = map(int, input().split())
c, d = map(int, input().split())

x, y = a*d + b*c, b*d

gcd_value = gcd(x, y)
print(f'{int(x/gcd_value)} {int(y/gcd_value)}')