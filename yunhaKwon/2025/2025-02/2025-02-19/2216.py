n = int(input())
w = []
for i in range(n):
    w.append(int(input()))
w.sort(reverse=True) #내림차순 정렬

result = []
for i in range(n):
    result.append(w[i] * (i+1))

print(max(result))