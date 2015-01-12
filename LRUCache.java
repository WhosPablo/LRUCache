import java.util.HashMap;

public class LRUCache <K,V> {
	private HashMap <K, DLLNode <K,V> > map;
	
	/** capacity and current size of cache **/
	private int capacity;
	private int size;

	private DLLNode <K,V> recent;
	private DLLNode <K,V>	old;

	public LRUCache(int capacity) {
		if (capacity<1) {
			throw new IllegalArgumentException("Capacity cannot be less than 1");
		}
		this.size = 0;
		this.capacity = capacity;
		this.map = new HashMap <K, DLLNode <K,V> > ();
	}

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

	public HashMap contains() {
		HashMap <K, V> returnMap = new HashMap <K, V> ();
		DLLNode <K,V> curr = recent;
		while(curr != null){
			returnMap.put(curr.key, curr.obj);
			curr = curr.next;
		}
		return returnMap;
	}


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

	public int size() {
        return size;
    }
 

}

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

