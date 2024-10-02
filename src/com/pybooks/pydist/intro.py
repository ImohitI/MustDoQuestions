"""
Tuples
pack a collection of values into an immutable objects tuple

"""
a = ()
b = (1,)
holding = (1, 2, 3)
n, s, p = holding
print(n, s, p)

holding = [(1, 2, 3), (2, 4, 6)]
total = sum([s * p for _, s, p in holding])
print(total)

"""
Set unordered collection of unique objects
find distinct values 
curly braces
elements of set are typically restricted to immutable objects
why , to be hashable
imm obj - state cannot be changed
mut obj - like list dict sets
has obj - hash value does not change

set use hashtable to store , so hash val must be same

key view, key always appears in the same orderas the items were inserted
list coversion always preserve this order

"""
names = {1, 2, 3}
print(type(names))
names_set = set(['I', 'B', 'I'])
print(names_set)
names = { s[0] for s in holding}
print(names)
names.add(4)
names.update({11,22,33,44})
print(names)
names.remove(44)
names.discard(2)
print(names)
# names.remove(44)
names.discard(2)

"""
dictionary , key value map

"""
s = {'1':1, '2':2}
print(s['1'])

if '1' in s :
    print('1 is there in dict key')

# del s['1']

l = list(s)
print(l)
k = s.keys()
print(k)
s['3'] = 3
print(k)

print(6/5)
print(6//5)

# a = {[1]}
# print(type(a)) # list dict unhashable object, mutable objects

"""
object comparison
x == y , test for equality
x is y , x is not y , see if they refer to literally same object in memory
generally we use == , is when you want to have the same identity
"""
class a:
    v = 1
a1 = a()
a2 = a()
print(a1 == a2)

print(2 == 2.0)

l1 = [1]
l2 = [1.0]
print(l1 == l2)
print(l1 is l2)
print(2 is 2.0)


"""
operations on sequences

"""
a = [3, 4, 5]
c = [list(a) for _ in range(4)]
print(c)

a = [0, 1, 2, 3, 4, 5, 6, 7]
print(a[2:5])
print(a[:3])
print(a[-3:])
print(a[0:5:2])
print(a[5::1])
print(a[5::-1])

a = [1, 2, 3, 4, 5]
a[1::2] = [10, 11]
print(a)


"""
object
type of an object is object's class
object id , id(), identity
is and is not uses this
type() returns type of an object
automatic garbage collection, all objects are reference counted

reference and copies
b = a , a new reference is created to a

shallow copy 
a = [1, 2]
b = list(a)

if b changed , new value added , a not changed
but if shared values changed , a also changed

deepcopy
b = copy.deepcopy(a)
"""

a = [1, 2, [3, 4]]
b = list(a)
print(b is a)
b.append(a)
b[2][0] = -100
print(a)

import copy
a = [1, 2, [3, 4]]
b = copy.deepcopy(a)
b[2][0] = -100
print(a)

"""
__new__ a static method called to create a new instance
__init__ called to initialize a new instance after it's created
__del__ called when an instance is being destroyed
__repr__ create a string representation
"""
# class SomeClass:
#     pass

# x = SomeClass.__new__(SomeClass, '1')
# if isinstance(x, SomeClass):
#     x.__init__('1')


"""
decorators
"""
def my_decorator(func):
    def wrapper():
        print("Something before the function.")
        func()
        print("Something after the function.")
    return wrapper

@my_decorator
def say_hello():
    print("Hello!")

say_hello()

"""
map
reduce
filter
"""
nums = [2, 3, 4]
sq = map(lambda x: x*x, nums)
print(sq)

for n in sq:
    print(n)

for n in filter(lambda x: x>2, nums):
    print(n)

from functools import reduce
total = reduce(lambda x, y: x + y, nums)

print(total)
product = reduce(lambda x, y: x * y, nums, 2)
print(product)


"""
generator and yield
function uses the yield keyword, it defines an object called generator
use of generator is to produce values for in iteration
generator is only executed whe you start iterating on it
"""
def countdown(n):
    print('counting down from', n)
    while n > 0:
        yield n
        n -= 1

for x in countdown(10):
    print('T-minus', x)

def countup(stop):
    n = 1
    while n <= stop:
        yield n
        n += 1

def countdown(start):
    n = start
    while n > 0:
        yield n
        n -= 1

def up_and_down(n):
    yield from countup(n)
    yield from countdown(n)

for x in up_and_down(5):
    print(x, end=' ')
