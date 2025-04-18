# 조건에 맞게 수열 변환하기 1
def solution(arr):
    for i in range(len(arr)):
        if arr[i] >= 50 and arr[i] % 2 == 0:
            arr[i] //= 2
        elif arr[i] < 50 and arr[i] % 2 != 0:
            arr[i] *= 2
    return arr

arr = [1, 2, 3, 100, 99, 98]

print(solution(arr))