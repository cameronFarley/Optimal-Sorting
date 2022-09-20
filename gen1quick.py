import sys

def quick_sort(list):
  length = len(list)
  if length <= 1:
    return list
  else:
    min_value = list.pop()
    
  items_greater = []
  items_lower = []
  
  for item in list:
    if item > min_value:
      items_greater.append(item)
    else:
      items_lower.append(item)
      
   return quick_sort(items_lower) + [min_value] + quick_sort(items_greater)

STDIN = []
userInput = sys.stdin

for line in userInput:
  line = line.lower().strip('\n')
  STDIN.append(line)
  
print(quick_sort(STDIN))
