# 배열의 원소만큼 추가하기
def solution(arr):
    answer = []
    for num in arr:
        answer += [num] * num
    return answer

arr = [5, 1, 4]

print(solution(arr))