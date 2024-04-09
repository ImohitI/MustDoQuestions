
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
from typing import List

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

# Define the dimensions of the matrix
R = 3
C = 3
 
# Recursive function to traverse the matrix
def traverse(arr, i, j):
    # If the current position is the bottom-right corner of
    # the matrix
    if i == R - 1 and j == C - 1:
        # Print the value at that position
        print(arr[i][j])
        # End the recursion
        return
 
    # Print the value at the current position
    print(arr[i][j], end=", ")
 
    # If the end of the current row has not been reached
    if j < C - 1:
        # Move right
        traverse(arr, i, j + 1)
    # If the end of the current column has been reached
    elif i < R - 1:
        # Move down to the next row
        traverse(arr, i + 1, 0)
 
# Define the matrix
arr = [ [1, 2, 3], [4, 5, 6], [7, 8, 9] ]
 
# Start the traversal from the top-left corner of the
# matrix
traverse(arr, 0, 0)


def rotate_matrix(matrix):
    n = len(matrix)

    # tranpse the matrix
    for i in range(n):
        for j in range(i, n):
            matrix[i][j] , matrix[j][i] = matrix[j][i] , matrix[i][j]

    # Reverse the columns
    for  i in range(n):
        for j, k in zip(range(n//2), range(n-1, n//2-1, -1)):
            matrix[j][i], matrix[k][i] = matrix[k][i], matrix[j][i]


def print_matrix(matrix):
    for row in matrix:
        print(' '.join(str(elem) for elem in row))

matrix = [[ 1, 2, 3, 4],[5, 6, 7, 8],[9, 10, 11, 12],[13, 14, 15, 16]]
    
print("Originam matrix")
print_matrix(matrix)
rotate_matrix(matrix)
print("Rotated matrix")
print_matrix(matrix)


def trap_2p(height):
    if not height: return 0

    l, r = 0, len(height) - 1
    leftMax, rightMax = height[l], height[r]
    res=0
    
    while l < r:
        if leftMax < rightMax:
            l += 1
            leftMax = max(leftMax, height[l])
            res += leftMax - height[l]
        else:
            r -= 1
            rightMax = max(rightMax, height[r])
            res += rightMax - height[r]
    
    return res

arr = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1] 
print('trap_2p --> ', trap_2p(arr))

def trap_preprocessing(arr):
    n = len(arr)
    left = [0] * n
    right = [0] * n
    left[0] = arr[0]

    for i in range(1,n-1):
        left[i] = max(left[i-1], arr[i])
    
    right[n-1] = arr[n-1]
    for i in range(n-2,0,-1):
        right[i] = max(right[i+1], arr[i])
    
    print(left)
    print(right)

    res = 0

    for i in range(0,n-1):
        res += min(left[i], right[i]) - arr[i]
    
    return res

arr = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1] 
print(trap_preprocessing(arr))
    

def trap(arr):
    n = len(arr)
    # indices to traverse the array
    left = 0
    right = n-1

    # to store leftmax and right max for two pointers of left and right
    l_max = 0
    r_max = 0

    # to store total amount of water
    result = 0

    while(left <= right):
        # we need to check minimum of left and right max for each element
        if r_max <= l_max:
             # add the difference between current value and right max at index r
            result  += max(0, r_max - arr[right])

            # update right max
            r_max = max(r_max, arr[right])

            # update right pointer
            right -= 1
        else:
            # add the diff btw curr value and left max at index l
            result += max(0, l_max - arr[left])

            # update left max
            l_max = max(l_max, arr[left])

            # update left pointer
            left += 1
    return result

arr = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1] 
print(trap(arr))

#max subarray product
def maxProduct(nums):
    res = max(nums)
    curMin, curMax = 1, 1

    for n in nums:
        if n == 0:
            curMin, curMax = 1, 1
            continue

        tmp = curMax * n
        curMax = max(n * curMax, n * curMin, n)
        curMin = min(tmp, n * curMin, n)
        res = max(res, curMax, curMin)
    
    return res

# equilibrium index ,  ...sum left...i...sum right , left and right sum equal

# 2 loop  solution , On2 and O1
def equilibrium_2Loops(arr):
    leftSum = 0
    rightSum = 0
    n = len(arr)

    # Check for indexes one by one until an equilibrium index is found
    for i in range(n):
        leftSum = 0
        rightSum = 0
        #get left sum
        for j in range(i):
            leftSum += arr[j]
        
        # get right sum
        for j in range(i + 1, n):
            rightSum += arr[j]
        
        # if leftsum and rightsum are same then we are done
        if leftSum == rightSum:
            print("LS = ", leftSum, " , RS = ", rightSum)
            return i
    
    return -1


arr = [-7, 1, 5, 2, -4, 3, 0]
print(equilibrium_2Loops(arr))


# using sum of the array O n , O 1
def equilibrium_sum(arr):
    totalSum = sum(arr)
    leftSum = 0
    for i, num in enumerate(arr):
        # total sum now becomes righ sum for index i
        totalSum -= num

        if leftSum == totalSum:
            print("LS = ", leftSum, " , RS = ", totalSum)
            return i
        
        leftSum += num
    
    return -1

print(equilibrium_sum(arr))

from typing import List
#using two pointers O n , O1
def equilibrium(nums: List[int]) -> int:
    left, pivot, right = 0, 0, sum(nums) - nums[0]
    while pivot < len(nums) -1 and right != left:
        pivot += 1
        right -= nums[pivot]
        left += nums[pivot - 1]

    return pivot if left == right else -1

# leaders in an array , an element is a leader if its
# greater than all the elements to its right side
# {16, 17, 4, 3, 5, 2} ---> 17, 5, 2
# o n* n , O 1
def printLeader_2loop(arr):
    size = len(arr)
    for  i in range(0, size):
        for j in range(i+1, size):
            if arr[i] <= arr[j]:
                break
        
        if j == size -1:
            print(arr[i], end=' ')

arr=[16, 17, 4, 3, 5, 2] 
printLeader_2loop(arr) 

# On On , finding the leader in same order in which it occurs
def printLeader_stack(arr):
    sk = []
    sk.append(arr[len(arr) -1])
    for i in range(len(arr) -2, -1, -1):
        if(arr[i] >= sk[len(sk) -1]):
            sk.append(arr[i])
    
    while(len(sk) != 0):
        print(sk[len(sk) - 1], end = ' ')
        sk.pop()

arr=[16, 17, 4, 3, 5, 2] 
printLeader_stack(arr) 

#On O1
def printLeader(arr):

     max_from_right= arr[len(arr) - 1]
     print(max_from_right, end= ' ')
     for i in range(len(arr) -2, -1, -1):
         if max_from_right < arr[i]:
             print(arr[i], end= ' ')
             max_from_right = arr[i]

arr=[16, 17, 4, 3, 5, 2] 
printLeader(arr) 


# On2 O1
def findPlatform(arr, dep, n):
    plat_needed = 1
    result = 1

    # run a nested loop to find overlap
    for i in range(n):
        # minimum platform needed
        plat_needed = 1

        for j in range(n):
        # check for overlap
            if i != j:
                if (arr[i] >= arr[j] and dep[j] >= arr[i]):
                    plat_needed += 1

        # update result
        result = max(result, plat_needed)

    return result  

arr = [100, 300, 500]
dep = [900, 400, 600]
print("{}".format(
        findPlatform(arr, dep, len(arr))))

# better solution ...
# O(N* log N) , O(N)
import heapq

def findPlatform_2(arr, dep, n):
    arr2 = []
    for i in range(n):
        arr2.append([arr[i]], dep[i])
    
    print(arr2)
    print(type(arr2))
    arr2.sort() # sort train based on arrival time

    p = []
    count = 1
    heapq.heappush(p, arr2[0][1])
    for i in range(1,n):
        if p[0] >= arr2[i][0]:
            count += 1
        else:
            heapq.heappop(p)
        heapq.heappush(p, arr2[i][1])
    
    return count

arr = [900, 940, 950, 1100, 1500, 1800]
dep = [910, 1200, 1120, 1130, 1900, 2000]
n = len(arr)
print(findPlatform(arr, dep, n))

# On*log n , O1
def findPlatform_3(Arr, dep, n):
    arr.sort()
    dep.sort()

    plat_needed = 1
    result = 1
    i = 1
    j = 0

    # similar to merge in merge sort to process all events in sorted order
    while(i < n and j < n):
        # if net event in sorted order is arrival, increment count of platforms needed
        if(arr[i] <= dep[j]):
            plat_needed += 1
            i += 1
        
        elif(arr[i] > dep[j]):
            plat_needed -= 1
            j += 1
        
        # update result if needed
        
        if(plat_needed > result):
            result = plat_needed
    
    return result
arr = [900, 940, 950, 1100, 1500, 1800]
dep = [910, 1200, 1120, 1130, 1900, 2000]
n = len(arr)
 
print("Minimum Number of Platforms Required = ",
      findPlatform(arr, dep, n))
            

# find min platform  

from typing import List
def find_platform_optimized(arr, dep, n):
    count = 0
    max_platform = 0

    # find the maximum departure time
    max_departure_time = max(dep)

    # create a list to store count of trains at each time
    v = [0]* (max_departure_time + 2)

    #increment othe count at the arrival time and decrement at the departure time
    for i in range(n):
        v[arr[i]] += 1
        v[dep[i] + 1] -= 1
    
    # Iterate over the list and keep track of the max sum seen so far
    for i in range(max_departure_time + 2):
        count += v[i]
        max_platform = max(max_platform, count)
    
    return max_platform

arr = [100, 300, 600]
dep = [900, 400, 500]
n = len(arr)
print(find_platform_optimized(arr, dep, n))