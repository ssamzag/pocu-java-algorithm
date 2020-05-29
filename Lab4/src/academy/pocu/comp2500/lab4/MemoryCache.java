package academy.pocu.comp2500.lab4;

import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.stream.IntStream;

public class MemoryCache {
    private static ArrayList<MemoryCache> memoryCache;
    private static int maxMemoryCacheCount;
    private int maxEntryCount;
    private String data;
    private LinkedHashMap<String, String> entry;
    private EvictionPolicy entryEvictionPolicy;
    private LinkedHashSet<String> entryMetaData;

    private MemoryCache(String data) {
        this.data = data;
        this.entry = new LinkedHashMap<String, String>(16, 0.75f, true);
        this.entryMetaData = new LinkedHashSet<String>();
        this.maxEntryCount = Integer.MAX_VALUE;
        this.entryEvictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
    }

    public static MemoryCache getInstance(String data) {
        if (memoryCache == null) {
            memoryCache = new ArrayList<MemoryCache>();
        }
        if (maxMemoryCacheCount == 0) {
            maxMemoryCacheCount = Integer.MAX_VALUE;
        }
        for (MemoryCache cache : memoryCache) {
            if (cache.data.equals(data)) {
                memoryCache.remove(cache);
                memoryCache.add(cache);
                return cache;
            }
        }
        if (maxMemoryCacheCount == memoryCache.size()) {
            memoryCache.remove(0);
        }

        var cache = new MemoryCache(data);
        memoryCache.add(cache);
        return cache;
    }

    public static void setMaxInstanceCount(int count) {
        maxMemoryCacheCount = count;
        if (memoryCache == null) {
            return;
        }

        if (count < memoryCache.size()) {
            int removeCount = memoryCache.size() - count;
            for (int i = 0; i < removeCount; ++i) {
                memoryCache.remove(0);
            }
            //IntStream.range(0,  ).forEach(i -> memoryCache.remove(i));
        }
    }

    public static void clear() {
        if (memoryCache == null) {
            return;
        }
        memoryCache.clear();
    }



    public void setEvictionPolicy(EvictionPolicy policy) {
        entryEvictionPolicy = policy;
    }

    public void setMaxEntryCount(int maxEntryCount) {
        this.maxEntryCount = maxEntryCount;
        if (this.entry.size() > maxEntryCount) {
            IntStream.range(0, entry.size() - maxEntryCount).forEach((i) -> runEntryEvictionPolicy());
        }
    }

    public void addEntry(String key, String value) {
        changeMemoryCachePriority();
        if (entry.containsKey(key)) {
            this.entry.put(key, value);
            return;
        }
        if (this.entry.size() == maxEntryCount) {
            runEntryEvictionPolicy();
        }

        this.entryMetaData.add(key);
        this.entry.put(key, value);
    }

    public String getEntryOrNull(String key) {
        changeMemoryCachePriority();
        return this.entry.get(key);
    }

    private void changeMemoryCachePriority() {
        memoryCache.remove(this);
        memoryCache.add(this);
    }

    private void runEntryEvictionPolicy() {
        var metaIterator = this.entryMetaData.iterator();
        switch (entryEvictionPolicy) {
            case FIRST_IN_FIRST_OUT:
                if (metaIterator.hasNext()) {
                    this.entry.remove(metaIterator.next());
                    metaIterator.remove();
                }
                break;
            case LAST_IN_FIRST_OUT:
                if (this.entryMetaData.size() > 0) {
                    String lastKey = "";
                    while (metaIterator.hasNext()) {
                        lastKey = metaIterator.next();
                    }
                    this.entry.remove(lastKey);
                    metaIterator.remove();
                }
                break;
            case LEAST_RECENTLY_USED:
                var entryIterator = this.entry.entrySet().iterator();
                if (entryIterator.hasNext()) {
                    var key = entryIterator.next().getKey();
                    this.entryMetaData.remove(key);
                    entryIterator.remove();
                }
                break;
            default:
                assert (false);
        }
    }
}