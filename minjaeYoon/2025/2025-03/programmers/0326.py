# 접미사인지 확인하기
def solution(my_string, is_suffix):
    answer = []
    result = 0
    for i in range(len(my_string)):
        answer.append(my_string[i:])
    if is_suffix in answer:
        result = 1
    return result

my_string = "banana"
is_suffix = "ana"

print(solution(my_string, is_suffix))