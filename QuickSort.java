import java.io.*;
import java.util.Date;
import java.util.Random;
import java.util.ArrayList;

public class QuickSort {
    public static void main(String[] args) {
        Date startTime = new Date();

        //-- expectation: command line arg1 = the path to the unsorted input file
        if (args.length != 1) {
            System.out.println("\n\n\tUSAGE: java MediocreSort <path-to-input-file>\n\n");
            System.exit(-1);
        }

        //-- verify the file supplied in the command line arg exists
        File inputFile = new File(args[0]);
        if (!inputFile.exists()) {
            System.out.println("\n\n\tERROR, supplied file [" + inputFile.getPath() + "] does not exist\n\n");
            System.exit(-2);
        }

        ArrayList<String> words = new ArrayList<>();

        //-- read the input file, line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile), 1024*1024*2)) {
            String eachLine;
            while ((eachLine = reader.readLine()) != null) {
                words.add(eachLine.trim().toLowerCase());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // printWords("BEFORE SORT:", words);
        quickSorter(words);
        // printWords("AFTER SORT:", words);

        //-- write the sorted words to output file
        File outputFile = new File(inputFile.getParent(), "sorted-" + inputFile.getName());
        System.out.println("*** writing sorted output to " + outputFile.getPath());

        try (BufferedWriter writer = new BufferedWriter((new FileWriter(outputFile)))) {
            for (String eachWord : words) {
                writer.write(eachWord);
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Date endTime = new Date();
        System.out.printf("*** total elapsed time to sort %,d words is %d ms %n", words.size(), endTime.getTime() - startTime.getTime());
    }

    static void printWords(String aLabel, ArrayList<String> aWords) {
        System.out.println("\n\n------------------\n" + aLabel + "\n\n\t" +
                String.join("\n\t", aWords) + "\n\n");
    }

    public static void quickSorter(ArrayList<String> aWords) {

        if (aWords.size() <= 1) {
            return;
        }

        int pivotIndex = new Random(System.currentTimeMillis()).nextInt(aWords.size());
        String pivotWord = aWords.get(pivotIndex);
        
        int size = aWords.size();
        ArrayList<String> greater = new ArrayList<>(size);
        ArrayList<String> lesser = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            if (i > pivotIndex) {
                greater.add(aWords.get(i));
            } else {
                lesser.add(aWords.get(i));
            }
        }

        aWords.clear();
        aWords.addAll(lesser);
        aWords.add(pivotWord);
        aWords.addAll(greater);
    }
}

