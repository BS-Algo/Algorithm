# 배열 만들기 3
def solution(arr, intervals):
    answer = []
    for interval in intervals:
        a, b = interval
        arr2 = arr[a:b+1]
        for a in arr2:
            answer.append(a)
    return answer

def solution(arr, intervals):
    answer = []
    for a,b in intervals: answer+=arr[a:b+1]
    return answer

arr	= [1, 2, 3, 4, 5]	
intervals = [[1, 3], [0, 4]]

print(solution(arr, intervals))
