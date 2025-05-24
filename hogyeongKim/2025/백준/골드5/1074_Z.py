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

# 예시
# 단계 1: 8×8을 4×4로 분할
# size = 4, r=5, c=6
# - r >= 4, c >= 4 → 4사분면 (우하)
# - 오프셋: 3 × 4² = 48
# - 상대좌표: (5-4, 6-4) = (1, 2)

# 단계 2: 4×4을 2×2로 분할  
# size = 2, r=1, c=2
# - r < 2, c >= 2 → 2사분면 (우상)
# - 오프셋: 1 × 2² = 4
# - 상대좌표: (1, 2-2) = (1, 0)

# 단계 3: 2×2을 1×1로 분할
# size = 1, r=1, c=0  
# - r >= 1, c < 1 → 3사분면 (좌하)
# - 오프셋: 2 × 1² = 2

# 총합: 48 + 4 + 2 = 54