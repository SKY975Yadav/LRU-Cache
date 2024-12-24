import java.util.LinkedHashMap;
import java.util.Map;

class LRUUsingLHM {
    LinkedHashMap<Integer,Integer> cache;
    private int capacity;
    LRUUsingLHM(int capacity){
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity,0.75f,true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    void put(int x,int y){
        cache.put(x,y);
    }
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
}
public class LRUCacheUsingLinkedHashMap {
    public static void main(String[] args) {
        LRUUsingLHM cache = new LRUUsingLHM(2);
        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(1)); // Output: 10
        cache.put(3, 30);
        System.out.println(cache.get(2)); // Output: -1 (key 2 is no longer in the cache)
        cache.put(4, 40);
        System.out.println(cache.get(1)); // Output: -1 (key 1 is no longer in the cache)
        System.out.println(cache.get(3)); // Output: 30
        System.out.println(cache.get(4)); // Output: 40
    }
}
