from typing import List
import array
import bisect
import collections

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        prevMap = {} #val : index
        for i, n in enumerate(nums):
            diff = target - n
            if diff in prevMap:
                return [prevMap[diff], i]
            prevMap[n] = i
        return
    
nums : List[int] = [3, 2, 4] 
target = 6
s = Solution()
print(s.twoSum(nums, 6))

nums : List[int] = [2] 
target = 4
s = Solution()
print(s.twoSum(nums, 2))
