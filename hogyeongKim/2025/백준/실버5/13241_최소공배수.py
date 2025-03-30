import sys
import math

a, b = map(int, sys.stdin.readline().split())

lcm = a * b // math.gcd(a, b)

print(lcm)