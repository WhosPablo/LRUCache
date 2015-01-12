# LRUCache
### LRUCache Implementation

A Last Recently Used Cache implemented using a HashMap and a Doubly Linked List.
Each time a object is accessed, it is added to the head of a queue implemented
using the Doubly Linked List. When the cache is full and a object needs to be 
added, the object at the end of that queue is evicted to make space for the 
new object

Pablo Arango


### Methods
- **LRUCache \<Key, Value\> (int capacity)**: Constructor for the LRU Cache takes in
an integer for the capacity of the LRU Cache. (Capacity cannot be 0 or less)
- **put(K key, V obj)**: Takes in the key and object and places it in the cache. If the cache is full then it will replace the last recently used Object.
- **get(K key)**: Takes in the key and returns the object in the cache if it is
 currently in the cache, else it returns null
- **contains()**: Returns a HashMap of the current keys and objects in the cache
- **size()**: Returns the currents size of the cache.

### Testing

The LRUCacheTests tests a few key items. It tests that the methods work properly and it tests that it can use different objects. The tests run through first using only integers then using integers and strings.