from itertools import combinations

def solution(nums):
    answer = 0

    nums.sort()
    n = nums[-1] + nums[-2] + nums[-3]
    n *= 2
    is_prime = [True] * (n)
    is_prime[0] = is_prime[1] = False

    for i in range(2, int(n**0.5) + 1):
        if is_prime[i]:
            for j in range(i*i, n, i):
                is_prime[j] = False
    
    prime_nums = set([i for i in range(n) if is_prime[i]])
    
    comb_nums = list(combinations(nums, 3))
    
    for numbers in comb_nums:
        if sum(numbers) in prime_nums:
            print(sum(numbers))
            answer += 1
    
    return answer