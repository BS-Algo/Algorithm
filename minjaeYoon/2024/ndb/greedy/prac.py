def only(n, k):
    result = 0
    while n >= k:
        if n % k == 0:
            n /= k
            result += 1
        else:
            n -= 1
            result += 1
    return result

n = 25
k = 5
print(only(n, k))

def only2(n, k):
    result = 0
    while n >= k:
        while n % k != 0:
            n -= 1
            result += 1
        n //= k
        result += 1
        
    while n > 1:
        n -= 1
        result += 1
    
    return result

print(only2(n, k))