# 연속된 수의 합
def solution(num, total):
    answer = []
    fir_num = (total - num * (num - 1) // 2 ) // num
    for i in range(num):
        answer.append(fir_num + i)
    return answer

num = 3
total = 12

print(solution(num, total))

