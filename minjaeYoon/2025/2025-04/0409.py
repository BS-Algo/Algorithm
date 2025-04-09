# n 번째 원소부터
def solution(num_list, n):
    return num_list[n-1:]

num_list = [2, 1, 6]
n = 3

print(solution(num_list, n))

# 순서 바꾸기
def solution(num_list, n):
    return num_list[n:] + num_list[:n]

num_list = [2, 1, 6]
n = 1

print(solution(num_list, n))

# 왼쪽 오른쪽
def solution(str_list):
    if not any(lst in str_list for lst in ["l", "r"]):
        return []
    
    for idx, lst in enumerate(str_list):
        if lst == "l":
            return str_list[:idx]
        elif lst == "r":
            return str_list[idx:]


str_list = ["u", "u", "l", "r"]

print(solution(str_list))

# 깔끔하게
def solution(str_list):
    for i, s in enumerate(str_list):
        if s == 'l':
            return str_list[:i]
        elif s == 'r':
            return str_list[i+1:]
    return [] # 어차피 전부 순회를 해야하니