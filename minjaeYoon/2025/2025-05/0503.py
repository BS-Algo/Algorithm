# 배열 만들기 6
def solution(arr):
    answer = []
    i = 0
    while i < len(arr):
        if not answer:
            answer.append(arr[i])
            i += 1
        elif answer and answer[-1] == arr[i]:
            del answer[-1]
            i += 1
        elif answer and answer[-1] != arr[i]:
            answer.append(arr[i])
            i += 1
    if not answer:
        return [-1]
    return answer

arr = [0, 1, 1, 1, 0]

print(solution(arr))