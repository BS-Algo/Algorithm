# 같은 숫자는 싫어
# https://school.programmers.co.kr/learn/courses/30/lessons/12906
def solution(arr):
    answer = []
    answer.append(arr[0])
    for i in range(1, len(arr)):
        if answer[-1] != arr[i]:
            answer.append(arr[i])
    return answer

print(solution([1,1,3,3,0,1,1]))

def no_continuous(s):
    a = []
    for i in s:
        if a[-1:] == [i]: continue
        a.append(i)
    return a