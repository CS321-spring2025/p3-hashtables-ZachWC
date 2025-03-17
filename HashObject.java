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

}
