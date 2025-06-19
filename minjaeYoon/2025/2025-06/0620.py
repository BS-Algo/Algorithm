# 배열 원소의 길이
def solution(strlist):
    return [len(x) for x in strlist]

strlist = ["We", "are", "the", "world!"]	

print(solution(strlist))