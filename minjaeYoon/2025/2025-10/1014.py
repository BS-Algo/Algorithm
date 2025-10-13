# 소수 만들기
# https://school.programmers.co.kr/learn/courses/30/lessons/12977?language=python3
def solution(nums):
    from itertools import combinations
    answer = 0
    num_set = list(combinations(nums, 3))
    
    def isprime(n):
        if n < 2:
            return False
        if n == 2:
            return True
        if n % 2 == 0:
            return False

        for i in range(3, int(n**0.5) + 1, 2):
            if n % i == 0:
                return False
        return True
    
    
    for i in range(len(num_set)):
        sum_num = sum(num_set[i])
        if isprime(sum_num):
            answer += 1

    return answer

print(solution([1,2,7,6,4]))

# 줄여보기
def solution(nums):
    from itertools import combinations
    
    def isprime(n):
        if n < 2:
            return False
        if n == 2:
            return True
        if n % 2 == 0:
            return False
        for i in range(3, int(n**0.5) + 1, 2):
            if n % i == 0:
                return False
        return True
    
    return sum(1 for combo in combinations(nums, 3) if isprime(sum(combo)))

# 다른 사람 풀이
from itertools import combinations
def prime_number(x):
    answer = 0
    for i in range(1,int(x**0.5)+1):
        if x%i==0:
            answer+=1
    return 1 if answer==1 else 0

def solution(nums):
    return sum([prime_number(sum(c)) for c in combinations(nums,3)])