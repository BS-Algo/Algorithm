# 최대공약수, 최소공배수
def solution(n, m):
    answer = []
    gcd = []
    lcm = []
    
    for i in range(1, min(n, m)+1):
        if n % i == 0 and m % i == 0:
            gcd.append(i)

    answer.append(max(gcd))
    
    for i in range(max(n, m), n*m+1):
        if i % n == 0 and i % m == 0:
            lcm.append(i)
    
    answer.append(min(lcm))
            
    
    return answer

print(solution(3, 12))
print(solution(2, 5))

# 유클리드 호제법
def gcdlcm(a, b):
    c,d = max(a, b), min(a, b)
    t = 1
    while t>0:
        t = c%d
        c, d = d, t
    answer = [ c, int (a*b/c)]
    return answer