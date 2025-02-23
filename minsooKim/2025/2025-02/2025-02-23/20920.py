N, M = map(int, input().split())
arr = []
cnt_dict = {}
for _ in range(N):
    word = input()
    if len(word) >= M:
        if word in cnt_dict:
            cnt_dict[word] += 1
        else:
            cnt_dict[word] = 1
        arr.append((word, cnt_dict[word]))
arr.sort(key=lambda x:(-x[1], -len(x[0]), x[0]))

latest_word = {}
for word, num in arr:
    latest_word[word] = num
for i in latest_word:
    print(i)