# 암호 해독
def solution(cipher, code):
    answer = ''
    for i in range(code-1, len(cipher), code):
        answer += cipher[i]
    return answer

cipher = "dfjardstddetckdaccccdegk"	
# cipher = "pfqallllabwaoclk"	
code = 4
# code = 2

print(solution(cipher, code))