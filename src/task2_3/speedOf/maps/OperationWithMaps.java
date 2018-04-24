package task2_3.speedOf.maps;

import task2_3.speedOf.MeasureTime;
import java.util.*;

public class OperationWithMaps {

    private int count;
    private int countElementForDeleting;

    protected OperationWithMaps(int count, int countElementForDeleting) {
        this.count = count;
        this.countElementForDeleting = countElementForDeleting;
        initializationListForDeleting(countElementForDeleting);
    }

    protected void deleteByIndex(Map<Integer, String> map) {
        MeasureTime measureTime = new MeasureTime();

        measureTime.setCount(countElementForDeleting);
        measureTime.start();
        for (int i=countElementForDeleting-1; i<countElementForDeleting-1; i--) {
            map.remove(i);
        }
        measureTime.finish();
        System.out.println(String.format("Time for Delete by Key (%s elements) (%s): %s", countElementForDeleting, map.getClass(), measureTime.getDuration()));
    }

    protected void containsValue(Map<Integer, String> map) {
        MeasureTime measureTime = new MeasureTime();

        measureTime.setCount(count);
        measureTime.start();
        for (Integer value : map.keySet()) {
            map.containsValue(value.toString());
        }
        measureTime.finish();
        System.out.println(String.format("Time for Contains Value (%s): %s", map.getClass(), measureTime.getDuration()));
    }

    protected void containsKey(Map<Integer, String> map) {
        MeasureTime measureTime = new MeasureTime();

        measureTime.setCount(count);
        measureTime.start();
        for (Integer key : map.keySet()) {
            map.containsKey(key);
        }
        measureTime.finish();
        System.out.println(String.format("Time for Contains Key (%s): %s", map.getClass(), measureTime.getDuration()));
    }

    protected void add(Map<Integer, String> map) {
        MeasureTime measureTime = new MeasureTime();

        measureTime.setCount(count);
        measureTime.start();
        initializationMap(map);
        measureTime.finish();
        System.out.println(String.format("Time for Add (%s): %s", map.getClass(), measureTime.getDuration()));
    }

    protected Map<Integer, String> initializationMap(Map<Integer, String> map) {
        for (int i=0; i<count; i++) {
            map.put(i, String.valueOf(i));
        }
        return map;
    }

    protected Map<Integer, String> initializationMapAndShuffle(Map<Integer, String> map) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<count; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int key : list) {
            map.put(key, String.valueOf(key));
        }
        return map;
    }

    private List<String> initializationListForDeleting(int count) {
        List<String> listForDeleting = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<count; i++) {
            listForDeleting.add(String.valueOf(random.nextInt(this.count)));
        }
        return listForDeleting;
    }
}
