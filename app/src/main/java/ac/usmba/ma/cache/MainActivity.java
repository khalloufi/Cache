package ac.usmba.ma.cache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ac.usmba.ma.cache.LFU.LFUCache;
import ac.usmba.ma.cache.LRU.LRUCache;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*LFUCache cache = new LFUCache(2,0.1f);
        cache.put(new Integer(1),new Integer(1));
        cache.put(new Integer(2),new Integer(2));
        System.out.println("1>>"+cache.get(new Integer(1)));
        cache.put(new Integer(3),new Integer(3));
        System.out.println("2>>"+cache.get(new Integer(2)));
        System.out.println("3>>"+cache.get(new Integer(3)));
        cache.put(new Integer(4),new Integer(4));
        System.out.println("4>>"+cache.get(new Integer(1)));
        System.out.println("5>>"+cache.get(new Integer(3)));
        System.out.println("6>>"+cache.get(new Integer(4)));*/

        LRUCache cache = new LRUCache(2);
        cache.put(new Integer(1),new Integer(1));
        cache.put(new Integer(2),new Integer(2));
        System.out.println("1>>"+cache.get(new Integer(1)));
        cache.put(new Integer(3),new Integer(3));
        System.out.println("2>>"+cache.get(new Integer(2)));
        System.out.println("3>>"+cache.get(new Integer(3)));
        cache.put(new Integer(4),new Integer(4));
        System.out.println("4>>"+cache.get(new Integer(1)));
        System.out.println("5>>"+cache.get(new Integer(3)));
        System.out.println("6>>"+cache.get(new Integer(4)));





    }
}
