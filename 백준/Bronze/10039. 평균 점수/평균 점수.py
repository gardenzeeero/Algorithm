total = 0
time = 0
while time < 5:
    score = int(input())
    if score < 40:
        score = 40
    total += score
    time += 1
total = int(total/5)
print(total)