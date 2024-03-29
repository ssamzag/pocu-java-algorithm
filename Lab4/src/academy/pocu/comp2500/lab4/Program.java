package academy.pocu.comp2500.lab4;

import java.util.LinkedHashMap;
import java.util.stream.IntStream;

public class Program {

    public static void main(String[] args) {
<<<<<<< HEAD
        MemoryCache.setMaxInstanceCount(2);
=======
        IntStream.range(0,4).forEach(i->System.out.println("dd"));

        MemoryCache.clear();
        MemoryCache.setMaxInstanceCount(5);

>>>>>>> 8ccd403ffe3ae5a74a4ebf6b2640e7d39372bf53
        MemoryCache memCacheA = MemoryCache.getInstance("A");
        MemoryCache memCacheB = MemoryCache.getInstance("B");
        MemoryCache memCacheC = MemoryCache.getInstance("C");
        MemoryCache memCacheD = MemoryCache.getInstance("D");
        MemoryCache memCacheE = MemoryCache.getInstance("E");

<<<<<<< HEAD
        assert memCacheA != MemoryCache.getInstance("A");
        assert memCacheB != MemoryCache.getInstance("B");
        assert memCacheC != MemoryCache.getInstance("C");
=======
        assert memCacheA == MemoryCache.getInstance("A");
        assert memCacheB == MemoryCache.getInstance("B");
        assert memCacheC == MemoryCache.getInstance("C");
        assert memCacheD == MemoryCache.getInstance("D");
        assert memCacheE == MemoryCache.getInstance("E");
>>>>>>> 8ccd403ffe3ae5a74a4ebf6b2640e7d39372bf53

        MemoryCache.setMaxInstanceCount(3);

        assert memCacheC == MemoryCache.getInstance("C");
        assert memCacheD == MemoryCache.getInstance("D");
        assert memCacheE == MemoryCache.getInstance("E");
        assert memCacheA != MemoryCache.getInstance("A");
        assert memCacheB != MemoryCache.getInstance("B");

        MemoryCache.clear();

        MemoryCache memCacheF = MemoryCache.getInstance("F");
        MemoryCache memCacheG = MemoryCache.getInstance("G");

        assert memCacheA == MemoryCache.getInstance("A");
        assert memCacheB == MemoryCache.getInstance("B");
        assert memCacheC == MemoryCache.getInstance("C");
        assert memCacheD == MemoryCache.getInstance("C");
        assert memCacheE == MemoryCache.getInstance("E");
        assert memCacheF == MemoryCache.getInstance("F");
        MemoryCache.setMaxInstanceCount(3);

        assert memCacheA != MemoryCache.getInstance("A");
        assert memCacheC != MemoryCache.getInstance("C");
        assert memCacheB != MemoryCache.getInstance("B");
        assert memCacheD != MemoryCache.getInstance("D");

        assert memCacheE != MemoryCache.getInstance("E");
        assert memCacheF != MemoryCache.getInstance("F");



        MemoryCache memCache = MemoryCache.getInstance("A");
        memCache.addEntry("key1", "value1");
        memCache.addEntry("key2", "value2");
        memCache.addEntry("key3", "value3");
        memCache.addEntry("key4", "value4");
        memCache.addEntry("key5", "value5");

        memCache.setMaxEntryCount(3);

        assert memCache.getEntryOrNull("key1") == null;
        assert memCache.getEntryOrNull("key2") == null;
        assert memCache.getEntryOrNull("key3") != null;
        assert memCache.getEntryOrNull("key4") != null;
        assert memCache.getEntryOrNull("key5") != null;

        memCache.addEntry("key6", "value6");

        assert memCache.getEntryOrNull("key3") == null;

        memCache.getEntryOrNull("key4");
        memCache.getEntryOrNull("key5");
        memCache.getEntryOrNull("key4");

        memCache.addEntry("key7", "value7");

        assert memCache.getEntryOrNull("key6") == null;

        memCache.addEntry("key5", "value5_updated");
        memCache.addEntry("key8", "value8");

        assert memCache.getEntryOrNull("key4") == null;

        assert memCache.getEntryOrNull("key5").equals("value5_updated");

        memCache.setEvictionPolicy(EvictionPolicy.FIRST_IN_FIRST_OUT);

        memCache.addEntry("key9", "value9");
        assert memCache.getEntryOrNull("key5") == null;

        memCache.addEntry("key10", "value10");
        assert memCache.getEntryOrNull("key7") == null;

        memCache.setMaxEntryCount(1);

        assert memCache.getEntryOrNull("key8") == null;
        assert memCache.getEntryOrNull("key9") == null;
        assert memCache.getEntryOrNull("key10").equals("value10");

        memCache.setMaxEntryCount(5);
        memCache.setEvictionPolicy(EvictionPolicy.LAST_IN_FIRST_OUT);

        memCache.addEntry("key11", "value11");
        memCache.addEntry("key12", "value12");
        memCache.addEntry("key13", "value13");
        memCache.addEntry("key14", "value14");

        assert memCache.getEntryOrNull("key10") != null;
        assert memCache.getEntryOrNull("key11") != null;
        assert memCache.getEntryOrNull("key12") != null;
        assert memCache.getEntryOrNull("key13") != null;
        assert memCache.getEntryOrNull("key14") != null;

        memCache.addEntry("key15", "value15");

        assert memCache.getEntryOrNull("key14") == null;

        assert memCache.getEntryOrNull("key13") != null;
        assert memCache.getEntryOrNull("key11") != null;
        assert memCache.getEntryOrNull("key12") != null;
        assert memCache.getEntryOrNull("key10") != null;
        assert memCache.getEntryOrNull("key15") != null;

        memCache.setEvictionPolicy(EvictionPolicy.LEAST_RECENTLY_USED);

        memCache.addEntry("key16", "value16");

        assert memCache.getEntryOrNull("key13") == null;
        assert memCache.getEntryOrNull("key10") != null;
        assert memCache.getEntryOrNull("key11") != null;
        assert memCache.getEntryOrNull("key12") != null;
        assert memCache.getEntryOrNull("key15") != null;
        assert memCache.getEntryOrNull("key16") != null;

    }
}
