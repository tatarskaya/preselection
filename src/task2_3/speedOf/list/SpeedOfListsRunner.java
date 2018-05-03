package task2_3.speedOf.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpeedOfLists {

    public static void main(String[] args) {

        int count = 10000;
        int countForDeleting = 150;
        int countNotFoundElement = 0;

        OperationWithLists operationWithList = new OperationWithLists(count, countForDeleting);
        List<String> list = operationWithList.initializationListAndShuffle(new ArrayList<>());

        System.out.println("Count of iteration: " + count);
        operationWithList.add(new ArrayList<>());
        operationWithList.add(new LinkedList<>());

        operationWithList.contains(list);
        operationWithList.contains(new LinkedList<>(list));

        List<String> arrayList = new ArrayList<>(list);
        List<String> linkedList = new LinkedList<>(list);
        operationWithList.deleteByValue(arrayList);
        countNotFoundElement = operationWithList.deleteByValue(linkedList);
        operationWithList.setCountElementForDeleting(countForDeleting - countNotFoundElement);

        arrayList = new ArrayList<>(list);
        linkedList = new LinkedList<>(list);
        operationWithList.deleteByIndex(arrayList);
        operationWithList.deleteByIndex(new LinkedList<>(linkedList));
    }
}
