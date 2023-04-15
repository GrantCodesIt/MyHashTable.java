package assignment.dictionary;

/*

 */


import java.util.*;
import java.io.*;
import java.util.Dictionary;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.BiFunction;



/**

 */


public class MyHashTable<K,V>
//        extends Dictionary<K,V>
 //       implements Map<K,V>, Cloneable, java.io.Serializable
{
     ArrayList<HashNode<K, V>> map;
    public MyHashTable() {
         map = new ArrayList<>();
    }
    public V put(K key, V value) {
        //than get node
        //add values to node?
        HashNode<K,V> head = map.get(getIndex(key));
        while(head != null) {
            if(head.key.equals(key)) {
                add(key,value);
            }
            head = head.next;
        }
        return value;
    }

    public V get(K key) {
        int hashcode = key.hashCode();
        int index = (hashcode & 0x7FFFFFFF) % map.size();
        HashNode<K,V> head = map.get(index);
        while(head != null) {
            if(head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public boolean containsKey(Object key) {
        if(contains(key) == true) {
            return true;
        }
        else return false;
    }

    public int size() {
        return mapSize;
    }
    public int getIndex(K key) {
        int hashcode = key.hashCode();
        if(hashcode < 0) {
            hashcode = hashcode * -1;
        }
        int index = (hashcode & 0x7FFFFFFF) % map.size();
        return index;
    }
    public Iterator<K> keySet() {
        /*
        Iterator<K> set = null;
        Iterator<HashNode<K,V>> thing = map.iterator();
        while(thing.hasNext() == true) {
            int hash = thing.hashCode();
            int index = (hash & 0x7FFFFFFF) % map.size();
            HashNode<K,V> head = map.get(index);
            set = map.get(index);
        }
        Iterator value = set.iterator();
    while(value.hasNext()) {
    }
         */
        //Iterator<K> set = (Iterator<K>) map.iterator();
        Iterator<K> keySet = getKeyIterator();
        return keySet;
    }
    public Iterator<V> values() {
    //Iterator<V> values = (Iterator<K>) map.iterator();
        Iterator<V> values = getValueIterator();
        return values;

    }
    public class HashNode <K,V> {
        K key;
        V value;
        MyHashTable<K, V>.HashNode<K, V> next;
        int hashCode;
        int index;
        public HashNode(K key, V value, int hashCode,int index) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
            this.index = index;
        }
    }
    int mapSize = 0;
    public V add(K key, V value)
    {
        int hashcode = key.hashCode();
        HashNode<K,V> head = new HashNode<>(key,value,hashcode,getIndex(key));
        // Check for Duplicates
        while ( head != null) {
            if(head.key.equals(key)) {
                break;
            }
            head = head.next;
        }
        // Add Key and Value to chain
        HashNode<K,V> newNode = new HashNode<K,V>(key,value,hashcode,getIndex(key));
        map.add(getIndex(key),newNode);
        newNode.next = head;
        mapSize++;

        /* Load Size
        int loadSize = N / M ;
        if( loadSize  >= 0.7) {
            ArrayList<HashNode<K,V>> temp = map;
            map = new ArrayList<>();
            N = N * 2;
            M = 0;
            for(int i=0; i < map.size(); ++i) {
                map.add(null);
            }
            for( HashNode<K,V>)
        }
        */
        return null;
    }


    public V remove(K key) {

        HashNode<K,V> head = map.get(getIndex(key));
        HashNode<K,V> prev = null;
        // Find Node in HashMap
        while(head !=null) {
            if(head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
            head.equals(head.next);
        }
        //No key exists
        if ( head == null) {
            return null;
        }
        // First index is the node
        if(prev == null) {
            map.set(getIndex(key), head.next);
        }
        // Set A to C and skips B.
        else {
            prev.next = head.next;
        }
        mapSize--;
        //Return removed value
        return head.value;
    }

    public V getValue(K key) {
        HashNode<K,V> head = map.get(getIndex(key));
        while(head != null) {
            if(head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        //Does not Exist
        return null;
    }

    public boolean contains(Object key) {
        if (map.iterator() == key) {
            return true;
        }
        else
            return false;
    }
    public Iterator<K> getKeyIterator() {
        Iterator it = map.iterator();

        while(it.hasNext()) {
            Object next = it.next();
            it.equals(next);
        }
        return it;
    }
    public Iterator<V> getValueIterator() {
        Iterator it = map.iterator();
        Iterator key = map.iterator();
        while(it.hasNext()) {
            Object next = it.next();
            if (map.contains(next)) {
                key.equals(next);
            }
            it.equals(next);
        }
        return key;
    }

    public boolean isEmpty() {
        Iterator it = map.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if(obj == null) {
                return true;
            }
            else
                return false;
        }
        return false;
    }
    public int getSize() {
        return mapSize;
    }
    public void clear() {
            Iterator it = map.iterator();
            while(it.hasNext() == true) {
                it.remove();
                it.next();
            }
        }

}


