n, k = map(int, input().split())
people = [i for i in range(1, n+1)]
result = []
idx = 0
while len(result) < n:
    idx = (idx + k - 1) % len(people)
    result.append(people.pop(idx))
    

print('<' + ', '.join(map(str, result)) + '>')