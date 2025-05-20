# 문자열 밀기
def solution(A, B):
    if A == B:
        return 0
    
    n = len(A)
    
    for i in range(1, n+1):
        shift = A[-i:] + A[:-1]
        if shift == B:
            return i

    return -1
    
A = "hello"	
B = "ohell"	

print(solution(A, B))