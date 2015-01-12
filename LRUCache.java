import java.util.HashMap;

/**
* A Last Recently Used Cache implemented using a HashMap and a Doubly Linked List.
* Each time a value is accessed, it is added to the head of a queue implemented
* using the Doubly Linked List. When the cache is full and a value needs to be 
* added, the value at the end of that queue is evicted to make space for the 
* new value
*
* Pablo Arango
**/

public class LRUCache <K,V> {

	private HashMap <K, DLLNode <K,V> > map;
	
	/** capacity and current size of cache **/
	private int capacity;
	private int size;

	/* head and tail of queue */
	private DLLNode <K,V> recent;
	private DLLNode <K,V>	old;

	/* Constructor for the LRU Cache takes in an integer as the capacity of
	 * the LRU Cache
	 */
	public LRUCache(int capacity) {
		if (capacity<=0) {
			throw new IllegalArgumentException("Capacity cannot be <= 0");
		}
		this.size = 0;
		this.capacity = capacity;
		this.map = new HashMap <K, DLLNode <K,V> > ();
	}

	/* Put places the object in the queue and in the hash map. If the 
	 * cache is full, it will replace the least recently used object
	 * with the new one and sets that node as the most recently accessed.
	 */
	public void put(K key, V obj) {

		if (map.containsKey(key)) {
			DLLNode <K,V> oldNode = map.get(key);
			oldNode.obj = obj;
			removeNode(oldNode);
			setRecent(oldNode);
		}
		else {
			DLLNode <K,V> newNode = new DLLNode <K,V>(key, obj);
			if (size < capacity) {
				setRecent(newNode);
				map.put(key, newNode);
				size++;
			}
			else {
				map.remove(old.key);
				old = old.pre;
				if (old != null){
					old.next = null;
				}
				setRecent(newNode);
				map.put(key, newNode);
			}
		}
	}

	/* Get uses the hashmap to access the Object in the node returns the value
	 * and then sets that node as the most recently accessed. If the node is not
	 * in the cache it returns null.
	 */
	public V get(K key) {
		if (map.containsKey(key)){
			DLLNode <K,V> recentNode = map.get(key);
			removeNode(recentNode);
			setRecent(recentNode);
			return recentNode.obj;
		}
		else {
			return null;
		}
	}

	/* Contains returns a HashMap of the current keys and objects in the
	 * cache
	 */
	public HashMap contains() {
		HashMap <K, V> returnMap = new HashMap <K, V> ();
		DLLNode <K,V> curr = recent;
		while(curr != null){
			returnMap.put(curr.key, curr.obj);
			curr = curr.next;
		}
		return returnMap;
	}

	/* Removes a node from the queue and sets the values for previous node 
	 * and next node of the surrounding nodes accordingly 
	 */
	public void removeNode(DLLNode <K,V> node) {
		DLLNode <K,V> cur = node;
		DLLNode <K,V> pre = cur.pre;
		DLLNode <K,V> post = cur.next;
 
		if (pre != null){
			pre.next = post;
		} 
		else{
			recent = post;
		}
 
		if(post != null) {
			post.pre = pre;
		} 
		else{
			old = pre;
		}
	}

	/* Sets a node as the most recently accessed
	 */
	public void setRecent(DLLNode <K,V> node){
		node.next = recent;
		node.pre = null;

		if (recent != null) {
			recent.pre = node;
		}

		recent = node;
		if (old == null) {
			old = node;
		}
	}

	/* Returns the current size of the cache
	 */
	public int size() {
        return size;
    }
 

}

/* Class for the separate nodes of the doubly linked list.
 */
class DLLNode <K,V> {
	public V obj;
	public K key;
	public DLLNode <K,V> pre;
	public DLLNode <K,V> next;
	public DLLNode(K key, V obj) {
		this.obj = obj;
		this.key = key;
	}
}

