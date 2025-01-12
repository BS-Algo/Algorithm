S = input()
S2 = set()
for i in range(1, len(S)+1):
    for j in range(len(S)-i+1):
        S2.add(S[j:j+i])
print(len(S2))