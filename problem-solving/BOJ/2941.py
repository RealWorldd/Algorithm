al = ("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")
word = input()
word_len = len(word)
count = 0
for x in al:
    al_count = word.count(x)
    count += al_count
print(word_len - count)

