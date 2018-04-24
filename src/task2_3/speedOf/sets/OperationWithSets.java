package task2_3.speedOf.sets;

import task2_3.speedOf.MeasureTime;
import java.util.*;

public class OperationWithSets {

    private int count;
    private int countElementForDeleting;
    private Set<Integer> elementsForDeleting;

    protected OperationWithSets(int count, int countElementForDeleting) {
        this.count = count;
        this.countElementForDeleting = countElementForDeleting;
        this.elementsForDeleting = initializationSetForDeleting(countElementForDeleting);
    }

    protected void deleteByValue(Set<Integer> set) {
        MeasureTime measureTime = new MeasureTime();
        int countNotFoundElemnts = 0;

        measureTime.setCount(countElementForDeleting);
        measureTime.start();
        for (int value : elementsForDeleting) {
            if (!set.remove(value)) {
                countNotFoundElemnts++;
            }
        }
        measureTime.finish();
        System.out.println(String.format("Time for Delete by Value (%s elements) (%s): %s", countElementForDeleting-countNotFoundElemnts, set.getClass(), measureTime.getDuration()));
    }

    protected void contains(Set<Integer> set) {
        MeasureTime measureTime = new MeasureTime();
        Iterator<Integer> iterator = set.iterator();

        measureTime.setCount(count);
        measureTime.start();
        while(iterator.hasNext()) {
            set.contains(iterator.next());
        }
        measureTime.finish();
        System.out.println(String.format("Time for Contains (%s): %s", set.getClass(), measureTime.getDuration()));
    }

    protected void add(Set<Integer> set) {
        MeasureTime measureTime = new MeasureTime();

        measureTime.setCount(count);
        measureTime.start();
        initializationList(set);
        measureTime.finish();
        System.out.println(String.format("Time for Add (%s): %s", set.getClass(), measureTime.getDuration()));
    }

    protected Set<Integer> initializationList(Set<Integer> set) {
        Random random = new Random();
        for (int i=0; i<count; i++) {
            set.add(random.nextInt(count));
        }
        return set;
    }

    private Set<Integer> initializationSetForDeleting(int count) {
        List<Integer> listForDeleting = new ArrayList<>();
        Set<Integer> setForDeleting = new HashSet<>();
        Random random = new Random();
        for (int i=0; i<count; i++) {
            listForDeleting.add(random.nextInt(this.count));
        }
        setForDeleting.addAll(listForDeleting);
        return setForDeleting;
    }
}
