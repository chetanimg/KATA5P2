package model;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Histogram <T>{
    
    private Map<T,Integer> map;
    
    public Histogram(){
        map = new TreeMap<>();
    }
    
    public Integer get(T key) {
        return map.get(key);
    }
    
    public Set<T> keySet(){
        Set <T> res = new TreeSet<>();
        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            T key = entry.getKey();
            res.add(key);
        }
        return res;
    }
    
    public void increment(T key){
        int value = map.containsKey(key) ? (map.get(key))+1 : 1;
        map.put(key, value);
    }
}
