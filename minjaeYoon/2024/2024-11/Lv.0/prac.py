def solution(num_list):
    num = len(num_list)
    bit, answer, comparison = 0, 1, 0
    for i in range(num):
        answer *= num_list[i]
        comparison += num_list[i]
        
    if answer > comparison**2:
        bit = 0
    else:
        bit = 1
    return bit

num_list = [3, 4, 5, 2, 1]
num_list_comparison = [5, 7, 8, 3]
print(solution(num_list))
print(solution(num_list_comparison))