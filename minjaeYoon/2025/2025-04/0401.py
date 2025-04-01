# 글자 지우기
def solution(my_string, indices):
    my_string = list(my_string)
    indices.sort(reverse=True)
    answer = ''
    for indice in indices:
        del my_string[indice]
    return answer.join(my_string)

my_string = "apporoograpemmemprs"
indices = [1, 16, 6, 15, 0, 10, 11, 3]

print(solution(my_string, indices))