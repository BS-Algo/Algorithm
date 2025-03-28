# 세로 읽기
def solution(my_string, m, c):
    answer = ''
    for i in range(0, len(my_string), m):
        answer += my_string[i:i+m][c-1]
    return answer

my_string = "ihrhbakrfpndopljhygc"
m = 4
c = 2

# my_string = 'programmers'
# m = 1
# c = 1

print(solution(my_string, m, c))

# print(my_string[0:4][c-1])