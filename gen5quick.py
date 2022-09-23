import sys

STDIN = []
userInput = sys.stdin

for line in userInput:
  line = line.lower().strip('\n')
  STDIN.append(line)

 def quick_sort(list):
    if len(list) <= 1:
      return list
    else: 
      min_value = list.pop()
      
    greater = []
    lesser = []
    
    for item in list:
      if item > min_value:
        greater.append(item)
      else:
        lesser.append(item)
    
    output = quick_sort(lesser) + [min_value] + quick_sort(greater)
    return output
  
print(quick_sort(STDIN))
