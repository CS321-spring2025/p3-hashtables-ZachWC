import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Manages Hash Table functionality
 * @author Zach Christensen
 */
public abstract class Hashtable{

    protected HashObject[] hashTable;
    protected int tableSize;
    protected double loadFactor;
    protected int n; //number of inserted elements
    public static final HashObject DEL = new HashObject("DEL"); // delete flag

    /**
     * Creates a new Hashtable with tableSize
     * @param size
     */
    public Hashtable(int size, double loadFactor){
        n = 0; //no elements inserted
        this.tableSize = size;
        this.loadFactor = loadFactor;
        hashTable = new HashObject[tableSize];
    }

    /**
     * Insert object into the hash table
     * @param key
     * @param value
     * @return
     */
    public boolean insert (Object key, HashObject value){
        if ((double) n / tableSize >= loadFactor) {
            return false; // Load factor exceeded
        }
        int probe = 0;
        int hi = hash(key, probe); //Initial hash index

        while (probe < tableSize && hashTable[hi] != null){
            if (hashTable[hi].equals(value)){
                hashTable[hi].incrementFrequency();
                return true;
            }
            probe++;
            hi = hash(key, probe);
        }

        if (probe >= tableSize){
            return false; //Table is full
        }

        hashTable[hi] = value; //Insert object
        value.setProbeCount(probe + 1);
        n++;
        return true;

    }

    /**
     * Finds and returns object in hashTable
     * @param key
     * @return
     */
    public HashObject find(Object key){
        int probe = 0;
        int hi = hash(key, probe);

        while (probe < tableSize && hashTable[hi] != null) {
            if (hashTable[hi].getKey().equals(key)){
                return hashTable[hi];
            }
            probe++;
            hi = hash(key, probe);
        }

       return null;

    }

    /**
     * Deletes object from hashtable
     * marks deleted spot with DEL
     * @param key
     */
    public void delete(Object key){
        int probe = 0;
        int hi = hash(key, probe);

        while (probe < tableSize && hashTable[hi] != null) {
            if (hashTable[hi].getKey().equals(key)){
                hashTable[hi] = DEL;
                n--;
                return;
            }
            probe++;
            hi = hash(key,probe);
        }
    }

    /**
     * Calculates hash for object
     * @param obj
     * @return
     */
    protected abstract int hash(Object key, int probe);

    /**
     * Helper method to handle negative hash codes
     * @param dividend
     * @param divisor
     * @return
     */
    protected int positiveMod (int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0)
        quotient += divisor;
        return quotient;
        }

    /**
     * Returns number of inserted elements
     * @return
     */
    public int getSize(){
        return n;
    }

    /**
     * Returns the size of the hashTable
     * @return
     */
    public int getTableSize(){
        return tableSize;
    }
        
    public void dumpToFile(String fileName) {
    try (PrintWriter out = new PrintWriter(fileName)) {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null && hashTable[i] != Hashtable.DEL) {
                out.println("table[" + i + "]: " + hashTable[i].toString());
            }
        }
    } catch (FileNotFoundException e) {
        System.err.println("Error writing to file: " + fileName);
        e.printStackTrace();
    }
}
}