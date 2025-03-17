public class LinearProbing extends Hashtable{

    public LinearProbing(int size, double loadFactor){
        super(size, loadFactor);
    }

    @Override
    protected int hash(Object key, int probe) { 
        int initialHash = positiveMod(key.hashCode(), tableSize);
        return positiveMod(initialHash + probe, tableSize);
    }
    
}
