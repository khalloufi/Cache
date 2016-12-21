package ac.usmba.ma.cache.LRU;

/**
 * Created by issam on 21/12/2016.
 */

public class Node {
    int key;
    String value;
    Node pre;
    Node next;

    public Node(int key, String value){
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Key : "+ this.key + " Value : "+this.value;
    }
}
