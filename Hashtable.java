public abstract class Hashtable{

    protected HashObject[] hashTable;
    protected int tableSize;
    protected int n; //number of inserted elements

    /*
     * Creates a new Hashtable with tableSize
     */
    public Hashtable(int size){
        n = 0; //no elements inserted
        tableSize = size;
        hashTable = new HashObject[tableSize];
    }

    /*
     * Insert object into the hash table
     */
    public boolean insert (int key, HashObject value){
        int i = 0;
        int hi = key % tableSize; //Initial hash index

        while (i < hashTable.length && hashTable[hi] != null){
            i = i +1;
            hi = (key % tableSize + i) % tableSize;
        }

        if (i >= tableSize){
            return false; //Table is full
        }

        hashTable[hi] = value; //Insert object
        return true;

    }

    /*
     * Helper method to handle negative hash codes
     */
    protected int positiveMod (int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0)
        quotient += divisor;
        return quotient;
        }

    /*
     * Returns number of inserted elements
     */
    public int getSize(){
        return n;
    }

    /*
     * Returns the size of the hashTable
     */
    public int getTableSize(){
        return tableSize;
    }
        
}