# 백트래킹

def back(x, sour, bitter, cnt):
    global result, N
    if x == N:
        # 재료를 하나도 사용하지 않으면 안 됨.
        if cnt == 0:
            return
        result = min(result, abs(bitter-sour))
        return
        
    # 재료를 사용했을 경우
    back(x+1, sour*ingredients[x][0], bitter+ingredients[x][1], cnt+1)
    
    # 재료를 사용하지 않았을 경우
    back(x+1, sour, bitter, cnt)
    
    
    
N = int(input())

ingredients = [list(map(int, input().split())) for _ in range(N)]

result = float('inf')
# 신 맛은 곱해지기 때문에 1부터 시작.
back(0, 1, 0, 0)
print(result)