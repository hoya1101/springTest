package com.sap.cache;

import java.util.Map;

import jersey.repackaged.com.google.common.collect.Maps;

public class CacheContext<T> {
	private Map<String, T> cache = Maps.newConcurrentMap();
	 
    public T get(String key){
        return  cache.get(key);
    }
 
    public void addOrUpdateCache(String key,T value) {
        cache.put(key, value);
    }
 
    public void evictCache(String key) {
        if(cache.containsKey(key)) {
            cache.remove(key);
        }
    }
 
    public void evictCache() {
        cache.clear();
    }
}
