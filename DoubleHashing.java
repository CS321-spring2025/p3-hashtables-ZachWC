/**
 * Implements double hashing hash function
 */
public class DoubleHashing extends Hashtable {

    public DoubleHashing(int size, double loadFactor) {
            super(size, loadFactor);
        }
    
    @Override
    protected int hash(Object key, int probe) { 
        int hash1 = positiveMod(key.hashCode(), tableSize);
        int hash2 = 1 + positiveMod(key.hashCode(), tableSize - 2);
        return positiveMod(hash1 + probe * hash2, tableSize);
    }
    
}
