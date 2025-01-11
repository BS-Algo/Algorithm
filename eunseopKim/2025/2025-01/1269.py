A, B = map(int, input().split())
AA = list(map(int, input().split()))
BB = list(map(int, input().split()))
AS = set(AA)
BS = set(BB)

set1 = AS-BS
set2 = BS-AS
cnt = 0
for _ in set1:
    cnt += 1
for _ in set2:
    cnt += 1
print(cnt)