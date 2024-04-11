
from typing import Counter


def firstUniqChar(s: str) -> int:
    cnt = Counter(s)
    for i, c in enumerate(s) :
        if cnt[c] == 1:
            return i
    return -1
    

print(firstUniqChar("leetcode"))
print(firstUniqChar("loveleetcode"))
