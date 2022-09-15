import java.util.Arrays;
import java.util.ArrayList;
import java.lang.System;

public class MediocreSort {
    public static void main(String[] args) {
        ArrayList<String> stdin = new ArrayList<>(Arrays.asList("Zebra", "Cat", "Eagle", "Yak", "Ant", "Deer", "Fish", "Dog"));
        System.out.println(stdin);
        insertionSort(stdin);
        System.out.println(stdin);
    }

    public static void insertionSort(ArrayList<String> words) {
        for(int i = 1; i < words.size(); i++) {
            String current = words.get(i);
            int index = i;
            while (index > 0 && current.compareTo(words.get(index - 1)) < 0) {
                words.set(index, words.get(index - 1));
                index--;
            }
            words.set(index, current);
            
        }
    }
}