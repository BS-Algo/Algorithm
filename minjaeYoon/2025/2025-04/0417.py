# 수열과 구간 쿼리 1
def solution(arr, queries):
    for query in queries:
        s, e = query
        for i in range(len(arr)):
            if s <= i and i <= e:
                arr[i] += 1  
    return arr

arr = [0, 1, 2, 3, 4]	
queries = [[0, 1],[1, 2],[2, 3]]

print(solution(arr, queries))