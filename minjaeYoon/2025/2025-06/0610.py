# 문자열 정리하기 (1)
def solution(my_string):
    answer = []
    for i in range(len(my_string)):
        if my_string[i].isdigit():
            answer.append(int(my_string[i]))
    return sorted(answer)

my_string = "hi12392"

print(solution(my_string))