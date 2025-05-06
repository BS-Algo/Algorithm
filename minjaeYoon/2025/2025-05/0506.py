# 배열 비교하기
def solution(arr1, arr2):
    answer = 0
    ar1 = len(arr1)
    ar2 = len(arr2)
    
    if ar1 > ar2 or (ar1 == ar2 and sum(arr1) > sum(arr2)) :
        return 1
    elif ar2 > ar1 or (ar1 == ar2 and sum(arr1) < sum(arr2)):
        return -1
    elif ar1 == ar2 and sum(arr1) == sum(arr2):
        return 0
        

arr1 = [49, 13]	
arr2 = [70, 11, 2]	

print(solution(arr1, arr2))