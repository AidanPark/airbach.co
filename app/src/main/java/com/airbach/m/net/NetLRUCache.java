package com.airbach.m.net;

import android.support.v4.util.LruCache;

/**
 * @author : Aidan(airbach.co@gmail.com)
 * @version : 1.0
 * @date : 2016-04-27.
 */
public class NetLRUCache extends LruCache<String, Object> {

    private static NetLRUCache netCache;

    public static NetLRUCache getInstance() {
        if (netCache == null) {
            netCache = new NetLRUCache();
        }
        return netCache;
    }

    private NetLRUCache() {
        this(getDefaultLruCacheSize());
    }

    private NetLRUCache(int sizeInKiloBytes) {
        super(sizeInKiloBytes);
    }

    public static int getDefaultLruCacheSize() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxMemory / 8;

        if(cacheSize > 256) {
            cacheSize = 256;
        }

        return cacheSize;
    }
}
