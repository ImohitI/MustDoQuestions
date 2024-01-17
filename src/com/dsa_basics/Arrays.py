
def reverseList(A, start, end):
    while start < end:
        A[start], A[end] = A[end], A[start]
        start += 1
        end -= 1

A = [1, 2, 3, 4, 5, 6] 
print(A) 
reverseList(A, 0, 5) 
print("Reversed list is") 
print(A) 

a = 1
b = 2

a , b = b , a
print(a,b)

def rotate(arr, n):
    last_el = arr[n-1]
    for i in range(n-1, 0, -1):
        arr[i] = arr[i-1]
    
    arr[0] = last_el

arr = [1, 2, 3, 4, 5, 6] 
n = len(arr)
for i in range(0, n):
    print(arr[i], end=' ')

print()

rotate(arr, n)
for i in range(0, n):
    print(arr[i], end=' ')

print()

print('09','12','2016', sep='-', end='\n')

from sys import maxsize

def maxSubArraySum(a, size):
    max_so_far = -maxsize -1
    max_ending_here = 0
    for i in range(0, size):
        max_ending_here = max_ending_here + a[i]
        if (max_so_far < max_ending_here):
            max_so_far = max_ending_here
        
        if max_ending_here < 0:
            max_ending_here = 0
    return max_so_far


a = [-2, -3, 4, -1, -2, 1, 5, -3]
 
print("Maximum contiguous sum is", maxSubArraySum(a, len(a)))


def sort012(a, arr_size):
    lo = 0
    hi = arr_size - 1
    mid = 0
    # Iterate till all the elements
    # are sorted
    while mid <= hi:
        # If the element is 0
        if a[mid] == 0:
            a[lo], a[mid] = a[mid], a[lo]
            lo = lo + 1
            mid = mid + 1
        # If the element is 1
        elif a[mid] == 1:
            mid = mid + 1
        # If the element is 2
        else:
            a[mid], a[hi] = a[hi], a[mid]
            hi = hi - 1
    return a

def printArray(a):
    for k in a:
        print(k, end=' ')
 
 
# Driver Program
arr = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
arr_size = len(arr)
arr = sort012(arr, arr_size)
printArray(arr)