t = int(input())

def eratosthenes(n):
    if n <= 2:
        return 2
        
    if n % 2 == 0:
        n += 1
        
    while True:
        prime_number = True
        for i in range(3, int(n**0.5) + 1, 2):
            if n % i == 0:
                prime_number = False
                break
        if prime_number:
            return n
        n += 2

for _ in range(t):
    n = int(input())
    print(eratosthenes(n))