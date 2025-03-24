# 접미사 배열
def solution(my_string):
    answer = []
    for i in range(len(my_string)):
        answer.append(my_string[i:])
    answer.sort()
    return answer

my_string = "banana"

print(solution(my_string))