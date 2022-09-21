import sys

def quick_sort(list):
  if len(list) <= 1:
    return list
  else:
    min_value = list.pop()
    
  greater = [item for item in list if item > min_value]
  lesser = [item for item in list if item < min_value]
  
  return quick_sort(lesser) + [min_value] + quick_sort(greater)

STDIN = []
userInput = sys.stdin

for line in usrInput:
  line = line.lower().strip('\n')
  STDIN.append(line)
  
print(quick_sort(STDIN))
