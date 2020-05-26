package academy.pocu.comp2500.lab4;

import java.util.ArrayList;
import java.util.Comparator;

import java.util.LinkedHashMap;

public class MemoryCache {
    private static ArrayList<MemoryCache> memoryCache;
    private static int maxMemoryCacheCount;
    private int maxEntryCount;
    private String instance;
    private LinkedHashMap<String, String> entry;
    private static long cacheMadeSeq;
    private long seq;
    private EvictionPolicy entryEvictionPolicy;

    public MemoryCache(String data) {
        this.instance = data;
        this.seq = ++cacheMadeSeq;
        maxMemoryCacheCount = Integer.MAX_VALUE;
    }

    public MemoryCache getInstance(String data) {
        if (maxMemoryCacheCount <= memoryCache.size()) {
            MemoryCache leastRecentlyCache = memoryCache
                    .stream()
                    .min(Comparator.comparing(MemoryCache::getSeq))
                    .get();
            memoryCache.remove(leastRecentlyCache);
        }
        memoryCache.add(new MemoryCache(data));
        this.entry = new LinkedHashMap<String, String>(22);
        this.entryEvictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
        return memoryCache.get(memoryCache.size() - 1);

    }

    public long getSeq() {
        return this.seq;
    }

    public void clear() {
        memoryCache.clear();
    }

    public void setMaxInstanceCount(int count) {
        maxMemoryCacheCount = count;
    }

    public void setEvictionPolicy(EvictionPolicy policy) {
        this.entryEvictionPolicy = policy;
    }

    public void addEntry(String key, String value) {
        if (entry.containsKey(key)) {
            this.entry.put(key, value);
            return;
        }

        runEntryEvictionPolicy();
        this.entry.put(key, value);
    }

    public LinkedHashMap<String, String> getEntryOrNull() {
        return this.entry.size() == 0 ? null : this.entry;
    }

    private void runEntryEvictionPolicy() {
        if (this.maxEntryCount < this.entry.size()) {
            switch (this.entryEvictionPolicy) {
                case FIRST_IN_FIRST_OUT:
                    this.entry.remove(0);
                    break;
                case LAST_IN_FIRST_OUT:
                    this.entry.remove(this.entry.size() - 1);
                    break;
                case LEAST_RECENTLY_USED:

                    break;
                default:
                    assert (false);
            }
        }

    }

}
