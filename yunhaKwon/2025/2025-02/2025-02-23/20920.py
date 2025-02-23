import sys
input = sys.stdin.readline

n, m = map(int, input().split())
word_list = {}

for _ in range(n):
    word = input().rstrip()

    if len(word) < m:
        continue
    else:
        if word in word_list:
            word_list[word] += 1
        else:
            word_list[word] = 1

ans = sorted(word_list.items(), key = lambda x: (-x[1], -len(x[0]), x[0]))

for w in ans:
    print(w[0])