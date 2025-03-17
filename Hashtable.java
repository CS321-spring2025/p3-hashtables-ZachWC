/**
 * Manages Hash Table functionality
 * @author Zach Christensen
 */
public abstract class Hashtable{

    protected HashObject[] hashTable;
    protected int tableSize;
    protected int n; //number of inserted elements
    public static final HashObject DEL = new HashObject("DEL"); // delete flag

    /**
     * Creates a new Hashtable with tableSize
     * @param size
     */
    public Hashtable(int size){
        n = 0; //no elements inserted
        tableSize = size;
        hashTable = new HashObject[tableSize];
    }

    /**
     * Insert object into the hash table
     * @param key
     * @param value
     * @return
     */
    public boolean insert (int key, HashObject value){
        int i = 0;
        int hi = positiveMod(key, tableSize); //Initial hash index

        while (i < hashTable.length && hashTable[hi] != null){
            i = i +1;
            hi = (key % tableSize + i) % tableSize;
        }

        if (i >= tableSize){
            return false; //Table is full
        }

        hashTable[hi] = value; //Insert object
        n++;
        return true;

    }

    /**
     * Finds and returns object in hashTable
     * @param key
     * @return
     */
    public HashObject find(int key){
        int i = 0;
        int hi = positiveMod(key, tableSize);

        while (i < hashTable.length && hashTable[hi] != null && !hashTable[hi].getKey().equals(key)) {
            i = i + 1;
            hi = positiveMod(key + i, tableSize);
        }

        if (i >= hashTable.length || hashTable[hi] == null) {
            return null;
        }

        return hashTable[hi];

    }

    /**
     * Deletes object from hashtable
     * marks deleted spot with DEL
     * @param key
     */
    public void delete(int key){
        int i = 0;
        int hi = positiveMod(key, tableSize);

        while (i < hashTable.length && hashTable[hi] != null && !hashTable[hi].getKey().equals(key)) {
            i = i + 1;
            hi = positiveMod(key + i, tableSize);
        }

        if (i >= hashTable.length || hashTable[hi] == null) {
            return;
        }

        hashTable[hi] = DEL;
        n--;
    }

    /**
     * Calculates hash for object
     * @param obj
     * @return
     */
    protected abstract int hash(HashObject obj);

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
        
}