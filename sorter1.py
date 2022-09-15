import sys

def insertion_sort(list):
  indexing_length = range(1, len(list))
  for i in indexing_length:
    value_to_sort = list[i]
    
    while list[i-1] > value_to_sort and i > 0:
      list[i], list[i-1] = list[i-1], list[i]
      i -= 1
      
   return list

STDIN = []
userInput = sys.stdin

for line in userInput:
  line = line.lower().strip('\n')
  STDIN.append(line)
  
print(insertion_sort(STDIN))
