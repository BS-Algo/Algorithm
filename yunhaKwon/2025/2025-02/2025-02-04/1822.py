N, M = map(int, input().split())
#배열 A, B 모두 set으로 중복 원소 제거 / 배열 B는 이분탐색 가능하도록 정렬
A = set(map(int, input().split()))
B = sorted(set(map(int, input().split())))

result = []

for a in A:
    start = 0
    end = len(B) - 1
    found = False  #B에서 a를 찾았는지 여부

    while start <= end:
        mid = (start + end) // 2
        if B[mid] == a:
            found = True
            break
        elif B[mid] < a:
            start = mid + 1
        else:
            end = mid - 1

    if not found:
        result.append(a)

print(len(result))
if result:
    print(*sorted(result))