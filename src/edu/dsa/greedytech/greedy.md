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


