# 카운트 다운
def solution(start_num, end_num):
    answer = []
    for i in range(start_num-end_num+1):
        answer.append(start_num-i)
    return answer

start_num = 10
end_num	= 3

print(solution(start_num, end_num))