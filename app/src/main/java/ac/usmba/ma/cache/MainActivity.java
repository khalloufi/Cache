package ac.usmba.ma.cache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ac.usmba.ma.cache.LRU.LRUCache;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LRUCache cache = new LRUCache(5);
        cache.clearCache();
        String simulation = "EIEIO";
        for(char c: simulation.toCharArray()){
            cache.set((int)c,""+c);
        }
        System.out.println("");
        cache.showCache();
    }
}
