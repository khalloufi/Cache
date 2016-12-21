package ac.usmba.ma.cache.LFU;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by issam on 21/12/2016.
 */

public class LFUCache {
    private int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node end = null;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    public String get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }

        return "";
    }

    public void remove(Node n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }

        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }

    }

    public void setHead(Node n){
        n.next = head;
        n.pre = null;

        if(head!=null)
            head.pre = n;

        head = n;

        if(end ==null)
            end = head;
    }

    public void set(int key, String value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node created = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);

            }else{
                setHead(created);
            }
            map.put(key, created);
        }
    }
    public void clearCache(){
        map = new HashMap<Integer, Node>();
    }
    public void showCache(){
        for (Map.Entry<Integer, Node> entry : map.entrySet())
        {
            System.out.print(entry.getValue().getValue()+" ");
        }
    }
}
