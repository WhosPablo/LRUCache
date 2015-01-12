
import static java.lang.System.*;

public class LRUCacheTests {

    public static void main(String[] args) {
		LRUCache <Integer, Integer> cache = new LRUCache <Integer, Integer>(4);


		cache.put(0,5);
		out.println("\nCache Contents:");
		out.println(cache.contains());
		test("Put (0,5) should make size 1", cache.size() == 1);

		int value = cache.get(0);
		out.println("\nCache Contents:");
		out.println(cache.contains());
	    test("Get 0 should be 5", value == 5);

	    cache.put(1,1);
	    cache.put(2,2);
	    cache.put(3,3);
	    cache.put(4,4);
	    out.println("\nCache Contents:");
		out.println(cache.contains());
		test("Size should be 4", cache.size() == 4);

		
		cache.get(2);
		cache.get(3);
		cache.get(4);
		cache.put(5,5);
		out.println("\nCache Contents:");
		out.println(cache.contains());
		test("Should Remove LRU (1,1)", cache.get(1) == null);

		cache.get(2);
		cache.get(3);
		cache.get(4);
		cache.get(5);
		cache.get(2);
		cache.put(6,6);
		out.println("\nCache Contents:");
		out.println(cache.contains());
		test("Should Remove LRU (3,3)", cache.get(1) == null);

		LRUCache <Integer, String> stringcache = new LRUCache <Integer, String>(4);

		stringcache.put(0,"Five");
		out.println("\nCache Contents:");
		out.println(stringcache.contains());
		test("Put (0,5) should make size 1", stringcache.size() == 1);

		String stringvalue = stringcache.get(0);
		out.println("\nCache Contents:");
		out.println(stringcache.contains());
	    test("Get 0 should be 'Five'", stringvalue == "Five");

	    stringcache.put(1,"One");
	    stringcache.put(2,"Two");
	    stringcache.put(3,"Three");
	    stringcache.put(4,"Four");
	    out.println("\nCache Contents:");
		out.println(stringcache.contains());
		test("Size should be 4", stringcache.size() == 4);

		
		stringcache.get(2);
		stringcache.get(3);
		stringcache.get(4);
		stringcache.put(5,"Five");
		out.println("\nCache Contents:");
		out.println(stringcache.contains());
		test("Should Remove LRU (1,1)", stringcache.get(1) == null);

		stringcache.get(2);
		stringcache.get(3);
		stringcache.get(4);
		stringcache.get(5);
		stringcache.get(2);
		stringcache.put(6,"Six");
		out.println("\nCache Contents:");
		out.println(stringcache.contains());
		test("Should Remove LRU (3,3)", stringcache.get(1) == null);


	}

	public static void test(String message, boolean test){

		out.print(message + " ..... ");
		if(test){
			out.println("Passed");
		}
		else{
			out.println("Failed");
		}
		
	}
}