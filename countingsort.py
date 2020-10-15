def countingSort(array,n):
    output = [0] * n
    m=array[0]
    for i in range(0,n):
       if array[i]>=m:
          m=array[i]
    count=[0]*(m+1)
    for i in range(0, n):
        count[array[i]] += 1
    for i in range(1, m+1):
        count[i] += count[i - 1]
    i = n - 1
    while i >= 0:
        output[count[array[i]] - 1] = array[i]
        count[array[i]] -= 1
        i -= 1
    for i in range(0, n):
        array[i] = output[i]