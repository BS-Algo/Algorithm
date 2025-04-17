import sys
input = sys.stdin.readline

a, b, c = map(int, input().split())

# print(pow(a, b, c))

def divide_and_conquer(base, exp, modular):
    if exp == 0:
        return 1
    
    half_div = divide_and_conquer(base, exp//2, modular)
    
    if exp % 2 == 0:
        return (half_div * half_div) % modular
    else:
        return (half_div * half_div * base) % modular

print(divide_and_conquer(a, b, c))