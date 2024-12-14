## Greedy 

Its an algorithmic paradigm that builds up a solution piece by piece
It makes a series of choices, each time picking the option that seems best at the moment, the most greedy choice 
With the goal of finding an overall optimal solution
Do not worry on future implication but only foucs on maximizing immediate benefits  
It makes a locally optimal choice in the hope that it will lead to a globally optimal solution  

Downside is might not lead us to the best solution for every problem 
By always opting for immediate benefit, we migh miss out on better options available down the line  

Suitable for some problems, especially those with specific structure  
Organizing networks , Prim's algorithm -- minimum of cable needed to connect all computer networks 

Optimization problem -- where we are looking to find the best solution under a given set of constraints 
                        could involve minimizing or maximizing some value, such as cost, distance, time or profit
Making local choices leads to global solution -- solved by making simple decisions based on current option or state 
                        without needing to look ahead or consider may failure possibilites  

Real world problems 
CPU scheduling algorithms -- managing how processes are assigned to the CPU for execution
Network Design in Lans
Friend recommendation on social network -- Dijkstra algorithm 


1. Jump Game 
Time complexity : O(n)
Space complexity : O(1)

2. Boats to Save People 
max 2 people on every boat
sort people , initialize left and right
if left + right < limit, left++, ,,, right-- ,,,, boats++
timecomplexity --> O(n log n) --> sorting algo
spacecomplexity --> O(n) --> sorting algo

3. gas station 
two arrays gas and cost 
finding if we can start and finish at a station 
the solution is unique 
Timecomplexity -- O(n)
Spacecomplexity -- O(1)

4. two city scheduling
[acost, bcost] city a , city b cost for all candidate 
n/2 people each city , minimum cost to invite all
cost length is even 
calculate ac1 -bc1, and sort
low value means a is min
high value means b is min
first half of sorted array goes to a, and second goes to b

sorting a 2d array based on diff
Arrays.sort(arr, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]))

then just take first n/2 a 0index and last n/2 b 1indiex
time complexity O nlogn
space complexity O n 


5. MinRefulStops
max heap of gas tank capacity encountered yet
keep going till u have gas
when exhausted check if refueled at max capacity will u be able to proceed 
We increase the maxdistance assuming we would stop at the max capacity gas station ecountered
increase the stop, if heap is empty and target still not reached return -1
when passing a gas station and fuel not required then add the capacity to max heap

java priority queue is minheap by default, add Collections.reverseOrder() , to make it max heap
Time complexity O(nlogn)
Space complexity On

6. Largest Palindromic Number
given a string of num, make the largest palindrome
freq map, start from largest, largest odd freq num is your middle

Time complexity On
Space complexity On
