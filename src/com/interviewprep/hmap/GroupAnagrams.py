from collections import defaultdict
from typing import List


class Solution:

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = defaultdict(list)
        for s in strs:
            k = "".join(sorted(s))
            d[k].append(s)
        return list(d.values())
    


d = defaultdict(list)
d["a"] = 1
d["b"] = 2

print(d)
print(d.values())

print(list(d.values()))

a = "sdfddxyz"
print(sorted(a))

print("".join(sorted(a)))
