# Variables are dynamically types
n = 0
# types are determined at runtime
print(type(n))
n = "abc"
print(type(n))

# Multiple assignments
n, m, z = 9, "abc", False

# Increment
n = n + 1
n += 1
# n++ not allowed

# None is null (absence of value)

if n > 2 :
    n -= 1

# while
n = 0
while n < 5:
    print(n)
    n += 1

# for loop
for i in range(5):
    print(i)

for i in range(2, 6):
    print(i)

for i in range(5, 1, -1):
    print(i)

# Division is decimal by defautl
print(5 / 2)
# Double slash rounds down
print(5 // 2)
# -2 not 0
print(-3 // 2) 
# to 
print(int(-3 // 2))

#Modding is similar
print(10 % 3)

# Except for negative values
print(-10 % 3)

import math
# math functions
print(math.fmod(-10, 3))
print(math.floor(3 / 2))
print(math.ceil(3 / 2))
print(math.sqrt(2))
print(math.pow(2, 3))

# Max / Min Int
float("inf")
float("-inf")

#Python numbers are infinite so they never overflow
print(math.pow(2, 200))

#But still less than infinity
print(math.pow(2, 200) < float("inf"))

# Arrays called list in python

# arrays are dyamic by default
arr = [1, 2, 3]
print(arr)
# can be used as stack
# push using append 
arr.append(4)
arr.append(5)
print(arr)
# pop using pop
arr.pop()
print(arr)
# can insert using insert
arr.insert(1, 7) # inserting in mid is O(n)
print(arr)

# Initialize arr of size n with default value of 1
n = 5
arr = [1] * n
print(arr)
print(len(arr))

# Careful -1 is not out of bounds, 
# its the last value
arr = [1, 2, 3]
print(arr[-1])
print(arr[-2]) # second last

# slicing 
print(arr[1:3]) # 3 is not inclued , same as for loop range

# unpacking
a, b, c = [1, 2, 3]

# loop throug array
nums = [1, 2, 3]

# using index
for i in range(len(nums)):
    print(nums[i])

# without index
for n in nums:
    print(n)


# with index and value
for i, n in enumerate(nums):
    print(i, n)

# loop through multiple arrays simultanesously
nums1 = [1, 3, 5]
nums2 = [2, 4, 6]
for n1, n2 in zip(nums1, nums2):
    print(n1, n2)

print('reverse and sort')
# reverse
nums1.reverse()
print(nums1)

# sort
arr = [4, 5, 8, 2, 3]
arr.sort()
print(arr)

arr.sort(reverse=True)
print(arr)

arr = ["bob", "alice", "jane", "doe"]

# Custom sort (by length of string)
arr.sort(key=lambda x: len(x))
print(arr)

# List comprehension
arr = [i+i for i in range(5)]
print(arr)


# 2-D lists
arr = [[0] * 4 for i in range(4)]
print(arr)

# strings are similar to arrays
s = "abc"
print(s[0:2])

# this creates a new string
s += "def"
print(s)

#valid numeric string can be converted
print(int("123") + int("123"))
# numbers can be converted to strings
print(str(123) + str(123))

# in rare cases you may need the ascii value of a char
print(ord("a"))
print(ord("A"))

# join a list together with a delimitor 
strings = ["ab", "cd", "ef"]
print("-".join(strings))

print('queue')
# Queues double ended queues
# pop from left of the queue in constant time unlike stack
from collections import deque

queue = deque()
queue.append(1)
queue.append(2)
print(queue)

queue.popleft()
print(queue)

queue.appendleft(1)
print(queue)

queue.pop()

print('set')
# Hash set , search and insert in constant time
mySet = set()
mySet.add(1)
mySet.add(2)
print(mySet)
print(len(mySet))

print(1 in mySet)
print(2 in mySet)
print(3 in mySet)

mySet.remove(2)
print(2 in mySet)

print('hashmap')
# hashmap aka dict

myMap = {}
myMap["alice"] = 88
myMap["bob"] = 77
print(myMap)
print(len(myMap))
print("bob" in myMap)
myMap["alice"] = 80
myMap.pop("alice")
print("alice" in myMap)

myMap = {"alice": 90, "bob": 70}

#dict comprehension
myMap = { i: 2*i for i in range(3)}
print(myMap)


# looping throwugh map

for key in myMap:
    print(key, myMap[key])

for val in myMap.values():
    print(val)

for key, val in myMap.items():
    print(key, val)


# Tuples are like arrays but immutable
tup = (1, 2, 3)
print(tup)
print(tup[0])
print(tup[-1])

# tup[2] = 0 will not work

## can be used as key for hash map/set
myMap = { (1, 2): 3}
print(myMap[(1, 2)])

mySet = set()
mySet.add((1, 2))
print((1, 2) in mySet)

# Lists can't ne keys, not hashable

# heaps
import heapq

# under the hood are arrays
minHeap = []

heapq.heappush(minHeap, 3)
heapq.heappush(minHeap, 2)
heapq.heappush(minHeap, 4)

print( "minHeap ", minHeap)

# min is always at index 0
print(minHeap[0])

while len(minHeap):
    print(heapq.heappop(minHeap))

# No max heaps by default, work around is to use
# min heap and multiply by -1 when push and pop

maxHeap = []
heapq.heappush(maxHeap, -3)
heapq.heappush(maxHeap, -2)
heapq.heappush(maxHeap, -4)

print("maxHeap ",maxHeap)

# max is always at index 0
print(-1 *  maxHeap[0])
while len(maxHeap):
    print(-1 * heapq.heappop(maxHeap))


# build heap from initial values
arr = [2, 1, 8, 4, 5]
heapq.heapify(arr)

while arr:
    print(heapq.heappop(arr))

#Functions
def myFunc(n, m):
    return n*m

# nested functions have access to outer

def outer(a, b):
    c = "c"

    def inner():
        return a + b + c
    return inner()

# can modifiy objects but not reassign 
# unless using nonlocal keyword

def double(arr, val):
    def helper():
        for i, n in enumerate(arr):
            arr[i] *= 2
        
        # will only modify val in the helper scope
        # cal *= 2

        # this will modify val outside helper scope
        nonlocal val
        val *= 2
    helper()
    print(arr, val)

nums = [1, 2]
val = 3

double(nums, val)

#Class
class MyClass:
    # constructor
    def __init__(self, nums):
        # create memeber variables
        self.nums = nums
        self.size = len(nums)
    
    # self key word requried as param
    def getLength(self):
        return self.size
    
