import java.io.File;
import java.io.FileNotFoundException;
//import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class HashtableExperiment {
    public static void main(String[] args) {
        if (args.length < 2 || args.length > 3){ // Invalid number of args
            System.out.println(getUsage());
            System.exit(1);
        }

        // read in args
        int dataSource = Integer.parseInt(args[0]);
        double loadFactor = Double.parseDouble(args[1]);
        int debugLevel = (args.length == 3)? Integer.parseInt(args[2]) : 0;

        int tableSize = TwinPrimeGenerator.generateTwinPrime(95500, 96000); // get tableSize from TwinPrime
        int numElements = (int) Math.ceil(loadFactor * tableSize);
        
        System.out.println("Hashtable Experiment: Found a twin prime table capacity: " + tableSize);
        System.out.println("Hashtable Experiment input: " + getDataSourceName(dataSource) + " Loadfactor " + loadFactor);

        System.out.println("\n    Using Linear Probing"); // experiment for linear probing
        runExperiment(new LinearProbing(tableSize, loadFactor), dataSource, numElements, debugLevel, "linear-dump.txt");

        System.out.println("\n    Using Double Hashing"); // experiment for linear probing
        runExperiment(new DoubleHashing(tableSize, loadFactor), dataSource, numElements, debugLevel, "linear-dump.txt");

    }

    /**
     * //TODO
     * @param table
     * @param dataSource
     * @param numElements
     * @param debugLevel
     * @param dumpFileName
     */
    private static void runExperiment(Hashtable table, int dataSource, int numElements, int debugLevel, String dumpFileName){
        System.out.println("HashtableExperiment: size of hash table is " + table.getTableSize());
        int duplicates = 0;
        long totalProbes = 0;
        Object[] data = generateData(dataSource, numElements);

        for(Object key : data) {
            HashObject object = new HashObject(key);
            boolean inserted = table.insert(key, object);
            if (inserted){
                totalProbes += object.getProbeCount();
                if (debugLevel == 2){
                    System.out.println("Inserted " + object);
                }
            } else{
                duplicates++;
                if (debugLevel == 2){
                    System.out.println("Duplicate " + object);
                }
            }
        }

        System.out.println("    Inserted " + numElements + " elements, of which " + duplicates + " were duplicates");
        double avgProbes = (double) totalProbes / (numElements - duplicates);
        System.out.printf("    Avg. no. of probes = %.2f\n", avgProbes);

        if (debugLevel >= 1){
            table.dumpToFile(dumpFileName);
            System.out.println("HashtableExperiment: Saved dump of hash table");
        }
    }

    /**
     * //TODO
     * @param dataSource
     * @param numElements
     * @return
     */
    private static Object[] generateData(int dataSource, int numElements){
        Object[] data = new Object[numElements];
        Random random = new Random();

        switch (dataSource){
            case 1:
            for(int i = 0; i < numElements; i++){
                data[i] = random.nextInt();
            }
            break;

            case 2:
            long current = new Date().getTime();
            for (int i = 0; i < numElements; i++){
                data[i] = new Date(current);
                current += 1000;
            }
            break;
            
            case 3:
            try (Scanner scanner = new Scanner(new File("word-list.txt"))){
                int i = 0;
                while (scanner.hasNext() && i < numElements) {
                    data[i++] = scanner.nextLine();
                }
            } catch (FileNotFoundException e){
                System.out.println("word-list.txt not found.");
                System.exit(1);
            }
            break;
        }
        return data;
    }

    /**
     * //TODO
     * @return
     */
    private static String getUsage(){
        return "Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]\n" +
               "    <dataSource>: 1 ==> random numbers, 2 ==> data value as long, 3 ==> word list\n" +
               "    <loadFactor>: the ratio of objects to table size, denoted by alpha = n/m\n" +
               "    <debugLevel>: ) ==> print summary, 1 ==> summary + dump, 2 ==> detailed debug";
    }

    /**
     * //TODO
     * @param dataSource
     * @return
     */
    private static String getDataSourceName(int dataSource){
        switch (dataSource) {
            case 1:
                return "Random Numbers";
            case 2:
                return "Date Values";
            case 3:
                return "Word-List";
            default:
                return "Unkown";
        }
    }
}
