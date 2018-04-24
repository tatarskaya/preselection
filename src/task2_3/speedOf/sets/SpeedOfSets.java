package task2_3.speedOf.sets;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SpeedOfSets {

    public static void main(String[] args) {

        int count = 10000;
        int countForDeleting = 150;
        Set<Integer> set;
        OperationWithSets operationWithSet = new OperationWithSets(count, countForDeleting);

        System.out.println("Count of iteration: " + count);
        operationWithSet.add(new HashSet<>());
        operationWithSet.add(new TreeSet<>());
        set = operationWithSet.initializationList(new HashSet<>());
        operationWithSet.contains(set);
        operationWithSet.contains(new TreeSet<>(set));
        operationWithSet.deleteByValue(set);
        set = operationWithSet.initializationList(new HashSet<>());
        operationWithSet.deleteByValue(new TreeSet<>(set));
    }
}
