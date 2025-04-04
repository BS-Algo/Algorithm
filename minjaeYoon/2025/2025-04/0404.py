# 리스트 자르기
def solution(n, slicer, num_list):
    answer = []
    a, b, c = slicer
    if n == 1:
        answer = num_list[0:b+1]
    elif n == 2:
        answer = num_list[a:]
    elif n == 3:
        answer = num_list[a:b+1]
    elif n == 4:
        answer = num_list[a:b+1:c]
    return answer

n = 3
slicer = [1, 5, 2]
num_list = [1, 2, 3, 4, 5, 6, 7, 8, 9]

print(solution(n, slicer, num_list))

# 다른 풀이 (리스트 자르기)	
def solution(n, slicer, num_list):
    a, b, c = slicer
    return [num_list[:b + 1], num_list[a:], num_list[a:b + 1], num_list[a:b + 1:c]][n - 1]

# 첫 번째로 나오는 음수
def solution(num_list):
    answer = []
    for i in range(len(num_list)):
        if num_list[i] <= -1:
            answer.append(i)
    if answer:
        return answer[0]
    else:
        return -1

# 다른 풀이 (원래 의도대로 할려고 했던거 enumerate)
def solution(num_list):
    for i, num in enumerate(num_list):
        if num <= -1:
            return i
    return -1

num_list = [12, 4, 15, 46, 38, -2, 15]	

print(solution(num_list))