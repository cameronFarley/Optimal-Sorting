import sys

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
  
STDIN = []
userInput = sys.stdin

for line in userInput:
  line = line.lower().strip('\n')
  STDIN.append(line)
  
print(quick_sort(STDIN))
