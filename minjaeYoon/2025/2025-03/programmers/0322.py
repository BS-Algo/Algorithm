# 배열 만들기 5
def solution(intStrs, k, s, l):
    answer = []
    for intStr in intStrs:
        ret_num = int(intStr[s:s+l])
        if ret_num > k:
            answer.append(ret_num)
    return answer

intStrs = ["0123456789","9876543210","9999999999999"]
k = 50000
s = 5
l = 5

print(solution(intStrs, k, s, l))

def solution(intStrs, k, s, l):
    return [int(intstr[s:s+l]) for intstr in intStrs if int(intstr[s:s+l]) > k]