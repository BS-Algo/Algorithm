# 문자열로 변환
def solution(n):
    return f"{n}"

n = 123	

print(solution(n))

# 배열의 원소 삭제하기
def solution(arr, delete_list):
    answer = []
    for i in range(len(arr)):
        if arr[i] not in delete_list:
            answer.append(arr[i])
        
    return answer

arr = [293, 1000, 395, 678, 94]
delete_list	= [94, 777, 104, 1000, 1, 12]

print(solution(arr, delete_list))

def solution(arr, delete_list): 
    return [i for i in arr if i not in delete_list]

# 부분 문자열인지 확인하기
def solution(my_string, target):
    if target in my_string:
        return 1
    else:
        return 0

my_string = "banana"
target = "ana"

print(solution(my_string, target))