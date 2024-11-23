Two Pointer
traversing sequential datastructure
one or both directions


1. Valid Palindrome
    Palindrome reads the same backward and forward
    2 pointer method time complexity On , space complexity O1

2. 3Sum
    array or integers : nums, an integer: target, find any three numbers whose sum = target
    f + l = target - m 
    first sort --> O nlogn
    nested loop  to find triplets --> On2
    Overall complexity --> On2
    space --> O logn , because of builtin Array.sort function which is timsort

    Now merge sort has space comp O(n) due to a temp array required to merge the element
    where timsort optimizes by using technique called galloping to reduce space requirement


3. Remove Nth Node from end of list
    remove 3rd node from end , 7 - 3 + 1, 5th node has to be deleted
    but for single pass we use two pointer
    move right to n steps, left and right are n nodes apart
    now move both left and right till right.next is null
    not left node is pointing to node before target node that is nth last node.
    left.next = left.next.next
    hence deleting the target node;

    here boundary case is when first time right is being moved by n and n is equal to length
    then right will be null
    hence in that case head.next will be answer which is to eliminate the head itself.

    Time complexity O(n)
    Space complexity O(1)

4. Sort Colors
    basic sort will be O nlogn
    now we are 3 colors
    0 to be added in the 0 list end at the start
    1 left unchecked
    2 to be added in the 2 list at begining of 2 list at the end

    if curr is 0 swap curr and start and move start and curr by 1
    if curr is 2 swap curr and end and move end back by 1
    till curr = end stop

    TC O(n), SC O(1)

5. reverse words in a string
    hello world --> world hello

    make a char arry, which has only one whitespace in btw
    revStr revers whole array

    now rever each part of array separeted by whitespace

    O(n) , O(n)

6. valid word abbreviation
    calendar --> cal end ar --> cal3ar
            ---> c alenda r --> c6r

    abrr index and word index, while loop with abbr index checked with abbr.length
    check and increase both word and abbr index
    when digit encountered, derive int and add to word index
    normal compare word char and abbr char

    o(n) o(1)

7. strobogrammatic number
    number same when flipped (view upside down), 0-0 1-1 8-8 6-9 9-6

8. min no of moves to make palindrome
    ccxx --> cxxc , 2 moves

    O(n2), outer loop i= 0 for n/2, inner loop k = j and works its way back to find i
    space O(1)

9. next palindrome using same digits
   12321 next greater palindrome 21312
   5 --> ""


10. lowest common anscestor of a binary tree III
    time complexity is O(h), where h is the height of the tree
    space O(1)

11. Valid Palindrome II
 ???