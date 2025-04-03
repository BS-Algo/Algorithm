def eratosthenes(n):
    prime_numbers = [True] * (2*n+1)
    prime_numbers[0], prime_numbers[1] = False, False
    
    for i in range(2, int((2*n)**0.5) + 1, 1):
        if prime_numbers[i]:
            for j in range(i*i, 2*n+1, i):
                prime_numbers[j] = False
                
    return len([i for i in range(n+1, 2*n+1) if prime_numbers[i]])



while True:
    n = int(input())
    if n == 0:
        break
    print(eratosthenes(n))