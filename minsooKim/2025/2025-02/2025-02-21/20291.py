N = int(input())
arr = []
cnt_dict = {}
for _ in range(N):
    file_name, file_add = input().split(".")
    if file_add in cnt_dict: 
        cnt_dict[file_add] += 1
    else:
        cnt_dict[file_add] = 1
    arr.append((file_add, cnt_dict[file_add]))
arr.sort(key=lambda x:x[0])

latest_count = {}
for ext, num in arr:
    latest_count[ext] = num
print(latest_count)
for ext in sorted(latest_count):
    print(ext, latest_count[ext])