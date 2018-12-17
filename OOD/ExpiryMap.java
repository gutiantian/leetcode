/* 这只是一个简单的 Expiration HashMap
*/

import java.sql.SQLSyntaxErrorException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ExpiryMap<K, V> {
    private long EXPIRY = 1000 * 60 * 2;
    private HashMap<K, V> valueMap;
    private HashMap<K, Long> expiryMap;

    public ExpiryMap() {
        this.valueMap = new HashMap<>();
        this.expiryMap = new HashMap<>();
    }

    public ExpiryMap(long defaultExpiryTime) {
        this.EXPIRY = defaultExpiryTime;
        this.valueMap = new HashMap<>();
        this.expiryMap = new HashMap<>();
    }

    public ExpiryMap(int initialCapacity, long defaultExpiryTime) {
        this.valueMap = new HashMap<>(initialCapacity);
        this.EXPIRY = defaultExpiryTime;
    }

    private boolean checkExpriy(K key) {
        if(!expiryMap.containsKey(key)) {
            return false;
        }

        long expriryTime = expiryMap.get(key);
        boolean flag = System.currentTimeMillis() > expriryTime;

        if(flag) {
            valueMap.remove(key);
            expiryMap.remove(key);
        }

        return flag;
    }

    public boolean containsKey(K key) {
        return valueMap.containsKey(key) && expiryMap.containsKey(key);
    }

    public V put(K key, V value) {
        expiryMap.put(key, System.currentTimeMillis() + EXPIRY);
        valueMap.put(key, value);
        return value;
    }

    public V put(K key, V value, long expiryTime) {
        valueMap.put(key, value);
        expiryMap.put(key, System.currentTimeMillis() + expiryTime);
        return value;
    }

    public int size() {
        return valueMap.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public V get(K key) {
        if(!valueMap.containsKey(key)) {
            return null;
        }

        if(checkExpriy(key)) {
            return null;
        }

        return valueMap.get(key);
    }
}