import java.util.HashMap;

class Node{
    Node prev,next;
    int key,value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUUsingHMAndDLL{
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    HashMap<Integer,Node> map = new HashMap<>();
    int capacity;
    LRUUsingHMAndDLL(int capacity){
        this.capacity=capacity;
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        if (map.containsKey(key)){
            Node data = map.get(key); // get the node

            remove(data); //remove the node

            insert(data); // insert at beg

            return data.value; // return the value

        }
        return -1;
    }
    void put(int key,int value){
        //if value is already present we move it to top
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        //if cache is full
        if(capacity == map.size()){
            remove(tail.prev);
        }
        //tail.prev --> least recently used
        insert(new Node (key,value));
    }
    void remove(Node data){
        map.remove(data.key);
        data.prev.next = data.next;
        data.next.prev = data.prev;

    }
    void insert(Node data){
        map.put(data.key, data);
        Node temp = head.next;
        head.next=data;
        data.prev=head;
        data.next=temp;
        temp.prev=data;
    }

}
public class LRUCacheUsingHMAndDoublyLL {
    public static void main(String[] args) {
        LRUUsingHMAndDLL cache = new LRUUsingHMAndDLL(2);
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
