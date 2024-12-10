def solution(arr, queries):
    for i in range(len(queries)):
        arr[queries[i][0]], arr[queries[i][1]] = arr[queries[i][1]], arr[queries[i][0]]
    return arr

arr = [0, 1, 2, 3, 4]
queries = [[0, 3],[1, 2],[1, 4]]
print(solution(arr, queries))