from typing import Counter, List


def intersect(nums1: List[int], nums2: List[int]) -> List[int]:
    counter = Counter(nums1)
    res = []
    for num in nums2:
        if counter[num] > 0:
            res.append(num)
            counter[num] -= 1
    return res

nums1: List[int] = [4,9,5]
nums2: List[int] = [9,4,9,8,4]

print(intersect(nums1, nums2))
