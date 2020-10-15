def heapify(arr, n, i):
    largest = i
    l = 2 * i + 1
    r = 2 * i + 2 
    
    if l < n and arr[i] < arr[l]:
        largest = l
    
    if r < n and arr[largest] < arr[r]:
        largest = r
    
    if largest != i:
        arr[i],arr[largest] = arr[largest],arr[i]
        heapify(arr, n, largest)
def heapSort(arr):
      n = len(arr)
  
      # Build max heap
      buildHeap(arr,n)
  
      for i in range(n-1, 0, -1):
          # Swap
          arr[i], arr[0] = arr[0], arr[i]
  
          # Heapify root element
          heapify(arr, i, 0)

def insert(arr, newNum):
    size = len(arr)
    if size == 0:
        arr.append(newNum)
    else:
        arr.append(newNum);
        for i in range((size//2)-1, -1, -1):
            heapify(arr, size, i)

def deleteNode(arr, num):
    size = len(arr)
    i = 0
    for i in range(0, size):
        if num == arr[i]:
            break
        
    arr[i], arr[size-1] = arr[size-1], arr[i]

    arr.remove(arr[size-1])
    
    for i in range((len(arr)//2)-1, -1, -1):
        heapify(arr, len(arr), i)

def buildHeap(arr, n): 
  
    # Index of last non-leaf node 
    startIdx = n // 2 - 1; 
  
    # Perform reverse level order traversal 
    # from last non-leaf node and heapify 
    # each node 
    for i in range(startIdx, -1, -1): 
        heapify(arr, n, i); 