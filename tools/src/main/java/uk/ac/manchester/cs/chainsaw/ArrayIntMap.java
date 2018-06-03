package uk.ac.manchester.cs.chainsaw;

import java.util.ArrayList;
import java.util.List;

/**
 * a multimap for int to collection of int values.
 */
public class ArrayIntMap {

    private final List<FastSet> map = new ArrayList<>();

    /**
     * @param key key
     * @param value value
     */
    public void put(int key, int value) {
        if (key >= map.size()) {
            while (key >= map.size()) {
                map.add(null);
            }
        }
        FastSet set = map.get(key);
        if (set == null) {
            set = new FastSetSimple();
            map.set(key, set);
        }
        set.add(value);
    }

    /**
     * returns a mutable set of values connected to the key; if no value is connected, returns an
     * immutable empty set
     *
     * @param key key
     * @return the set of values connected with the key
     */
    public FastSet get(int key) {
        if (key < map.size()) {
            FastSet collection = map.get(key);
            if (collection != null) {
                return collection;
            }
        }
        return new FastSetSimple();
    }

    /**
     * @param k key
     * @return true if k is a key for the map
     */
    public boolean containsKey(int k) {
        return k < map.size() && map.get(k) != null;
    }

    /**
     * Clear the map
     */
    public void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        return "MultiMap " + map.toString();
    }
}
