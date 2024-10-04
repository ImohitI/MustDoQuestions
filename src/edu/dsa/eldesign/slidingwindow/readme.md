Given two strings, s and t, find the minimum window substring in s, which has the following properties:

It is the shortest substring of s that includes all of the characters present in t.

It must contain at least the same frequency of each character as in t.

The order of the characters does not matter here.

Strings s and t consist of uppercase and lowercase English characters.

s,t length < 10^3


Naive approach is look at all the substring of s and see if it has all characters from t and its frequency matches
Then among them find the shortest substring
Time complexity will be On2 where n is the size of s 
Space complexity will be On

Optimized approach sliding window
start from 0 index of s and keep going till to find all characters form t
Then we try to minimize the size of the window

abcfeayg   ace
HM reqCount 
a 1
c 1
e 1

Window will be to track of elements being found from t
HM window
a 0
c 0
e 0

Var current and required
current represent the current state of matched characters , starts with size 0 , increment as soon as we match one with its frequency
required represent the desirable state of matched characters , size 3

When current == required we have matched it

How to adjust ??
we start with a var left , left pointer and right is just the iterator
now we have found out initial substring 
keep moving left fwd if current == required
when current < required , move right until u get current == required
Also every result is being store and the last smallest result is the answer