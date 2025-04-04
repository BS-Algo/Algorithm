N, M = map(int, input().split())
arr = [0] * M
answer = []

for _ in range(N):
    lst = list(map(int, input().split()))    
    person = lst[1:]
    answer.append(person)
    for x in person:
        arr[x - 1] += 1

# 공유 숫자 리스트
shared = set(i + 1 for i in range(M) if arr[i] >= 2)
print(answer)
print(shared)

T = 0
# 공유 숫자 전체를 한 번에 제거한 뒤 확인
for person in answer:
    filtered = [x for x in person if x not in shared]
    print(filtered)
    if not filtered:
        T = 1
        break

print(1 if T else 0)
