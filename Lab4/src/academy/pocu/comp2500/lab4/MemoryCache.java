package academy.pocu.comp2500.lab4;

import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.stream.IntStream;

public class MemoryCache {
    private static LinkedHashMap<String, MemoryCache> memoryCache = new LinkedHashMap<String, MemoryCache>(16, 0.75f, true);
    private static int maxMemoryCacheCount = Integer.MAX_VALUE;

    private LinkedHashMap<String, String> entry;
    private LinkedHashSet<String> entryMetaData;
    private EvictionPolicy entryEvictionPolicy;
    private int maxEntryCount;

    private MemoryCache() {
        this.entry = new LinkedHashMap<String, String>(16, 0.75f, true);
        this.entryMetaData = new LinkedHashSet<String>();
        this.maxEntryCount = Integer.MAX_VALUE;
        this.entryEvictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
    }

    public static MemoryCache getInstance(String data) {
        if (memoryCache.containsKey(data)) {
            memoryCache.get(data).getEntryOrNull("Abc");
            return memoryCache.get(data);
        }

        if (maxMemoryCacheCount == memoryCache.size()) {
            memoryCache.remove(0);
        }
        var cache = new MemoryCache();
        memoryCache.put(data, cache);
        return cache;
    }

    public static void setMaxInstanceCount(int count) {
        maxMemoryCacheCount = count;
        IntStream.range(0,  memoryCache.size() - count).forEach(i -> memoryCache.remove(0));
    }

    public static void clear() {
        memoryCache.clear();
    }

    public void setEvictionPolicy(EvictionPolicy policy) {
        this.entryEvictionPolicy = policy;
    }

    public void setMaxEntryCount(int maxEntryCount) {
        this.maxEntryCount = maxEntryCount;
        IntStream.range(0, entry.size() - maxEntryCount).forEach(i -> runEntryEvictionPolicy());
    }

    public void addEntry(String key, String value) {
        //changeMemoryCachePriority();
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
        //changeMemoryCachePriority();
        return this.entry.get(key);
    }

    private void runEntryEvictionPolicy() {
        switch (entryEvictionPolicy) {
            case FIRST_IN_FIRST_OUT:
                var fifoIterator = this.entryMetaData.iterator();
                if (fifoIterator.hasNext()) {
                    this.entry.remove(fifoIterator.next());
                    fifoIterator.remove();
                }
                break;
            case LAST_IN_FIRST_OUT:
                var lifoIterator = this.entryMetaData.iterator();
                if (this.entryMetaData.size() > 0) {
                    String lastKey = "";
                    while (lifoIterator.hasNext()) {
                        lastKey = lifoIterator.next();
                    }
                    this.entry.remove(lastKey);
                    lifoIterator.remove();
                }
                break;
            case LEAST_RECENTLY_USED:
                var entryIterator = this.entry.entrySet().iterator();
                if (entryIterator.hasNext()) {
                    String key = entryIterator.next().getKey();
                    entryIterator.remove();
                    this.entryMetaData.remove(key);
                }
                break;
            default:
                assert (false);
        }
    }
}