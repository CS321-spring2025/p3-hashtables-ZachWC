public class LinearProbing extends Hashtable{

    public LinearProbing(int size){
        super(size);
    }

    @Override
    protected int hash(HashObject obj) {
        return positiveMod(obj.getKey().hashCode(), tableSize);
    }
    
}
