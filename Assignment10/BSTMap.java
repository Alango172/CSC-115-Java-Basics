import java.util.*;

public class BSTMap<K extends Comparable<K>, V > implements  Map<K, V>  {

    BinarySearchTree<K,V> bst;

    public BSTMap () {
        bst = new BinarySearchTree<K,V>();
    }


    public long getGetLoopCount() {
        return bst.getFindLoopCount();
    }

    public long getPutLoopCount() {
        return bst.getFindLoopCount();
    }

    public void resetGetLoops() {
        bst.resetFindLoops();
    }

    public void resetPutLoops() {
        bst.resetFindLoops();
    }

    public boolean containsKey(K key) {
        try{
			bst.find(key);
			return true;
		} catch(KeyNotFoundException a){
			return false;
		}
    }

    public V get (K key) throws KeyNotFoundException {
        return bst.find(key);
    }

    public List<Entry<K,V> >  entryList() {
        // you are free to choose your traversal order here
        return bst.entryList();
    }

    public void put (K key, V value) {
        bst.insert(key,value);
    }

    public int size() {
        return bst.count;
    }

    public void clear() {
        bst.clear();
    }

}
