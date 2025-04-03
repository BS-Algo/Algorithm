# 가까운 1 찾기
def solution(arr, idx):
    answer = 0
    numbers = []
    for i in range(len(arr)):
        if arr[i] == 1 and idx <= i:
            numbers.append(i)
    if numbers:
        answer = numbers[0]
    else:
        answer = -1
    return answer

arr = [0, 0, 0, 1]
idx = 1

print(solution(arr, idx))

# 다른 풀이 (가까운 1 찾기)
def solution(arr, idx):
    answer = 0
    try:
        answer = arr.index(1, idx)
    except:
        answer = -1

    return answer