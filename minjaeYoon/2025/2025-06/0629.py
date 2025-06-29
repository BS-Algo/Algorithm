# 모음 제거
def solution(my_string):
    answer = []
    my_string = list(my_string)
    lst = ['a', 'e', 'i', 'o', 'u']
    for i in range(len(my_string)):
        if my_string[i] not in lst:
            answer.append(my_string[i])
    return ''.join(answer)

my_string = "nice to meet you"	

print(solution(my_string))