package ac.usmba.ma.cache.LFU;

/**
 * Created by issam on 21/12/2016.
 */

public class Node {
    int key;
    String value;
    int frequent;
    Node pre;
    Node next;

    public Node(int key, String value){
        this.key = key;
        this.value = value;
        this.frequent = 1;
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

    public int getFrequent() {
        return frequent;
    }
    public void isVisited() {
        this.frequent++;
    }

    @Override
    public String toString() {
        return "Key : "+ this.key + " Value : "+this.value;
    }
}
