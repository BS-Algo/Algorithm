n = int(input())
numbers = [int(input()) for _ in range(n)]
numbers.sort()
counts = {number:0 for number in numbers}
print(round(sum(numbers)/n))
print(numbers[n//2])

for number in numbers:
    counts[number] += 1

result = []
mx_cnt = max(counts.values())
for key, val in counts.items():
        if val == mx_cnt:
            result.append(key)
result.sort()
if len(result) > 1:
    print(result[1])
else:
    print(result[0])
print(max(numbers) - min(numbers))