# 특별한 이차원 배열 2
def solution(arr):
    for i in range(len(arr)):
        for j in range(len(arr)):
            if arr[i][j] != arr[j][i]:
                return 0
    return 1

# 종료 시킬 수 있는 상황만 

arr = [[5, 192, 33], [192, 72, 95], [33, 95, 999]]

print(solution(arr))