n, r, c = map(int, input().split())

result = 0
# 전체 배열 크기는 2의 n제곱
size = 2 ** n

# n
while size > 1:
    size //= 2
    
    # 어느 사분면인지 판단
    # 1사분면 (왼쪽 위)
    if r < size and c < size:        
        pass
    # 2사분면 (오른쪽 위), 시작값 = (2^(N-1))²
    elif r < size and c >= size:
        result += size * size
        c -= size
    # 3사분면 (왼쪽 아래), 시작값 = 2 × (2^(N-1))²
    elif r >= size and c < size:
        result += 2 * size * size
        r -= size
    # 4사분면 (오른쪽 아래), 시작값 = 3 × (2^(N-1))²
    else:
        result += 3 * size * size
        r -= size
        c -= size

print(result)