# n번째 원소까지
def solution(num_list, n):
    return num_list[:n]

num_list = [2, 1, 6]
n = 1

print(solution(num_list, n))

# n개 간격의 원소들
def solution(num_list, n):
    return num_list[::n]

num_list = [4, 2, 6, 1, 7, 6]
n = 2

print(solution(num_list, n))

# 홀수 vs 짝수
def solution(num_list):
    odd = sum(num_list[::2])
    even = sum(num_list[1::2])
    
    if odd > even:
        return odd
    elif odd < even:
        return even
    elif odd == even:
        return odd

# max 를 까먹은
def solution(num_list):
    return max(sum(num_list[::2]), sum(num_list[1::2]))

num_list = [4, 2, 6, 1, 7, 6]

print(solution(num_list))

# 5명씩
def solution(names):
    return names[::5]

names = ["nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx"]	

print(solution(names))