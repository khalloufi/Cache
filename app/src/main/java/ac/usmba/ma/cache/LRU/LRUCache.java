package ac.usmba.ma.cache.LRU;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by issam on 21/12/2016.
 */

public class LRUCache <Key, Value> implements Map<Key, Value>{
    private int maxCacheSize;
    private final Map<Key, LRUCache.CacheNode<Key, Value>> cache;

    CacheNode head = null;
    CacheNode end = null;

    public LRUCache(int maxCacheSize) {
        this.maxCacheSize = maxCacheSize;
        this.cache = new HashMap<Key, CacheNode<Key, Value>>(maxCacheSize);

    }
    public void remove(CacheNode node){
        if(node.previous !=null){
            node.previous.next = node.next;
        }else{
            head = node.next;
        }
        if(node.next!=null){
            node.next.previous = node.previous;
        }else{
            end = node.previous;
        }
    }
    public void setHead(CacheNode node){
        node.next = head;
        node.previous = null;

        if(head!=null)
            head.previous = node;

        head = node;

        if(end ==null)
            end = head;
    }
    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.cache.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @NonNull
    @Override
    public Set<Entry<Key, Value>> entrySet() {
        return null;
    }

    @Override
    public Value get(Object key) {
        if(cache.containsKey(key)){
            CacheNode node = cache.get(key);
            remove(node);
            setHead(node);
            return (Value) node.value;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.cache.isEmpty();
    }

    @NonNull
    @Override
    public Set<Key> keySet() {
        return this.cache.keySet();
    }

    @Override
    public Value put(Key key, Value value) {
        if(cache.containsKey(key)){
            CacheNode old = cache.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            CacheNode node = new CacheNode(key, value);
            if(cache.size() >= maxCacheSize){
                cache.remove(end.key);
                remove(end);
                setHead(node);
            }else{
                setHead(node);
            }
            cache.put(key, node);
        }
        return value;
    }

    @Override
    public void putAll(Map<? extends Key, ? extends Value> map) {
        for (Map.Entry<? extends Key, ? extends Value> me : map.entrySet()) {
            put(me.getKey(), me.getValue());
        }
    }

    @Override
    public Value remove(Object key) {
        CacheNode<Key, Value> currentNode = cache.remove(key);
        return currentNode.value;
    }

    @Override
    public int size() {
        return cache.size();
    }

    @NonNull
    @Override
    public Collection<Value> values() {
        return null;
    }

    private static class CacheNode<Key, Value> {

        public final Key key;
        public Value value;
        public CacheNode previous;
        public CacheNode next;

        public CacheNode(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
}
