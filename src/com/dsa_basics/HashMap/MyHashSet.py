"""
hashset without any built-in hastable libraries

void add(key) : insert the value key into hashset
bool contains(key) : return whether the value key exist or not
void remove(key) : removes value key in the hashset.
"""

class ListNode:
    def __init__(self, key):
        self.key = key
        self.next = None

class MyHashSet(object):

    def __init__(self):
        self.set = [ListNode(0) for i in range(10**4)]

    def add(self, key):
        index = key % len(self.set)
        cur = self.set[index]

        while cur.next:
            if cur.next.key == key:
                return
            cur = cur.next        
        cur.next = ListNode(key)


    def remove(self, key):
        index = key % len(self.set)
        cur = self.set[index]

        while cur.next:
            if cur.next.key == key:
                cur.next = cur.next.next
                return
            cur = cur.next        

        
    def contains(self, key):
        index = key % len(self.set)
        cur = self.set[index]

        while cur.next:
            if cur.next.key == key:
                return True
            cur = cur.next  
        
        return False

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        hashset = set()
        for n in nums:
            if n in hashset:
                return True
            hashset.add(n)
        return False
    
    def singleNumber(self, nums) -> int:
        res = 0
        for n in nums:
            res = n ^ res
        return res
    
    def intersection(self, nums1, nums2):
        seen = set(nums1)

        res = []
        for n in nums2:
            if n in seen:
                res.append(n)
                seen.remove(n)
        return res

    def isHappy(self, n: int) -> bool:
        visit = set()

        while n not in visit:
            visit.add(n)
            n = self.sumOfSquares(n)
            
            if n == 1:
                return True
            
        return False
    
    def sumOfSquares(Self, n: int) -> int:
        output = 0
        while n:
            digit = n % 10
            digit = digit ** 2
            output += digit
            n = n // 10
        return output