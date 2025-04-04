def eratosthenes(n):
    prime_numbers = [True] * (n+1)
    prime_numbers[0], prime_numbers[1] = False, False
    
    for i in range(2, int(n**0.5) + 1, 1):
        if prime_numbers[i]:
            for j in range(i*i, n+1, i):
                prime_numbers[j] = False
                
    return [i for i in range(n+1) if prime_numbers[i]]

t = int(input())

for _ in range(t):
    n = int(input())
    result = set(eratosthenes(n))
    cnt = set()
    for i in range(n):
        if i in result and (n-i) in result:
            tmp = [i, n-i]
            tmp.sort()
            cnt.add(tuple(tmp))
    print(len(cnt))