public class DoubleHashing extends Hashtable {

    public DoubleHashing(int size) {
            super(size);
        }
    
    @Override
    protected int hash(HashObject obj) {
        return positiveMod(obj.getKey().hashCode(), tableSize);
    }

    private int secondHash(HashObject obj){
        return 1 + positiveMod(obj.getKey().hashCode(), tableSize - 2);
    }
    
}
