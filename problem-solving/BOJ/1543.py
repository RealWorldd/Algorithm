text = input()
findText = input()
result = 0
i = 0
while i < len(text):
    index = i
    for j in range(0, len(findText)):
        if index >= len(text):
            i += 1
            break
        if text[index] == findText[j]:
            if j == len(findText) - 1:
                result += 1
                i += len(findText)
                break
            index += 1
            continue
        i += 1
        break
print(result)

