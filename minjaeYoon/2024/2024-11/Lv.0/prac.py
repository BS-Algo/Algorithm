def solution(arr, queries):
    answer = []
    for query in queries:
        min_value = float('inf')
        s, e, k = query

        for num in arr:
            if s <= num <= e and k < num:
                min_value = min(min_value, num)
        if min_value == float('inf'):
            answer.append(-1)
        else:
            answer.append(min_value)
    return answer

arr = [0, 1, 2, 4, 3]
queries = [[0, 4, 2],[0, 3, 2],[0, 2, 2]]
