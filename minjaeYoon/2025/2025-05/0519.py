# 7의 개수
def solution(array):
    answer = 0
    array = list(map(str, array))
    for arr in array:
        for j in range(len(arr)):
            if arr[j] == '7':
                answer += 1
    return answer

array = [7, 77, 17]

print(solution(array))