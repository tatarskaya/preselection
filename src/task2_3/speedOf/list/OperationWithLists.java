package task2_3.speedOf.list;

import task2_3.speedOf.MeasureTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OperationWithLists {

    private int count;
    private int countElementForDeleting;
    private List<String> elementsForDeleting;

    public OperationWithLists(int count, int countElementForDeleting) {
        this.count = count;
        this.countElementForDeleting = countElementForDeleting;
        this.elementsForDeleting = initializationListForDeleting(countElementForDeleting);
    }

    public void setCountElementForDeleting(int countElementForDeleting) {
        this.countElementForDeleting = countElementForDeleting;
    }

    public void deleteByIndex(List<String> list) {
        MeasureTime measureTime = new MeasureTime();

        measureTime.setCount(countElementForDeleting);
        measureTime.start();
        for (int i=countElementForDeleting-1; i>=0; i--) {
            try {
                    list.remove(i);
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println(String.format("The element with the index (%s) is not found", i));
            }
        }
        measureTime.finish();
        System.out.println(String.format("Time for Delete by Index (%s elements) (%s): %s", countElementForDeleting, list.getClass(), measureTime.getDuration()));
    }

    public int deleteByValue(List<String> list) {
        MeasureTime measureTime = new MeasureTime();
        int countNotFoundElements = 0;

        measureTime.setCount(countElementForDeleting);
        measureTime.start();
        for (String element : elementsForDeleting) {
            if (!list.remove(element)) {
                countNotFoundElements++;
            }
        }
        measureTime.finish();
        System.out.println(String.format("Time for Delete by Value (%s elements) (%s): %s", countElementForDeleting-countNotFoundElements, list.getClass(), measureTime.getDuration()));
        return countNotFoundElements;
    }

    public void contains(List<String> list) {
        MeasureTime measureTime = new MeasureTime();

        measureTime.setCount(count);
        measureTime.start();
        for (String element : list) {
            list.contains(element);
        }
        measureTime.finish();
        System.out.println(String.format("Time for Contains (%s): %s", list.getClass(), measureTime.getDuration()));
    }

    public void add(List<String> list) {
        MeasureTime measureTime = new MeasureTime();

        measureTime.setCount(count);
        measureTime.start();
        initializationList(list);
        measureTime.finish();
        System.out.println(String.format("Time for Add (%s): %s", list.getClass(), measureTime.getDuration()));
    }

    public List<String> initializationList(List<String> list) {
        for (int i=0; i<count; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }

    public List<String> initializationListAndShuffle(List<String> list) {
        for (int i=0; i<count; i++) {
            list.add(String.valueOf(i));
        }
        Collections.shuffle(list);
        return list;
    }

    private List<String> initializationListForDeleting(int count) {
        List<String> listForDeleting = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<count; i++) {
            listForDeleting.add(String.valueOf(random.nextInt(count)));
        }
        Collections.shuffle(listForDeleting);
        return listForDeleting;
    }
}
