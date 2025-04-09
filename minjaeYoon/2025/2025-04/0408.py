# 배열 조각하기
def solution(arr, query):
    for i in range(len(query)):
        if i % 2 == 0:
            arr = arr[:query[i]+1]
        elif i % 2 == 1:
            arr = arr[query[i]:]
    return arr

arr = [0, 1, 2, 3, 4, 5]
query = [4, 1, 2]

print(solution(arr, query))