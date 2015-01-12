# LRUCache
### LRUCache Implementation

A Last Recently Used Cache implemented using a HashMap and a Doubly Linked List.
Each time a value is accessed, it is added to the head of a queue implemented
using the Doubly Linked List. When the cache is full and a value needs to be 
added, the value at the end of that queue is evicted to make space for the 
new value

Pablo Arango


### Methods
- **LRUCache <K,V>**:
- **LRUCache**:
- **LRUCache**: