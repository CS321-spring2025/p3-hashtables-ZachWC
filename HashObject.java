public class HashObject {
    private Object key;
    private int frequency;
    private int probeCount;

    /*
     * Creates HashObject 
     */
    public HashObject(Object key){
        this.key = key;
        this.frequency = 1; //inserting for the first time
        this.probeCount = 0;
    }

    /*
     * Returns key
     */
    public Object getKey(){
        return key;
    }

    /*
     * Returns frequency
     */
    public int getFrequency(){
        return frequency;
    }

    /*
     * Increments frequency
     */
    public void incrementFrequency(){
        this.frequency++;
    }

    /*
     * Return probeCount
     */
    public int getProbeCount(){
        return probeCount;
    }

    /*
     * Sets probeCount
     */
    public void setProbeCount(int probe){
        this.probeCount = probe;
    }

    @Override
    public boolean equals(Object key){
        if (this == key){
            return true;
        }
        if (key == null || getClass() != key.getClass()){ // if null or different class type
            return false;
        }

        HashObject otherObj = (HashObject) key;

        return this.key.equals(otherObj.key);
    }

    @Override
    public String toString() {
        return key + " " + frequency + " " + probeCount;
    }

    //TODO REMOVE WHEN DONE
    // public static void main(String[] args) {
    //     // Create HashObject instances
    //     HashObject obj1 = new HashObject("apple");
    //     HashObject obj2 = new HashObject("apple");
    //     HashObject obj3 = new HashObject("banana");
    //     HashObject obj4 = obj1;  // obj4 is the same reference as obj1

    //     // Test equality
    //     System.out.println("obj1.equals(obj2): " + obj1.equals(obj2));  // Should be true (same key)
    //     System.out.println("obj1.equals(obj3): " + obj1.equals(obj3));  // Should be false (different key)
    //     System.out.println("obj1.equals(obj4): " + obj1.equals(obj4));  // Should be true (same reference)

    //     // Test with a null object
    //     System.out.println("obj1.equals(null): " + obj1.equals(null));  // Should be false (null is never equal to a HashObject)

    //     // Test with an object of a different class
    //     Object someOtherObject = new Object();
    //     System.out.println("obj1.equals(someOtherObject): " + obj1.equals(someOtherObject));  // Should be false (different class)
    // }
}
