package task2_3.speedOf.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SpeedOfMaps {

    public static void main(String[] args) {

        int count = 10000;
        int countForDeleting = 100;
        Map<Integer, String> map;
        OperationWithMaps operationWithMaps = new OperationWithMaps(count, countForDeleting);

        System.out.println("Count of iteration: " + count);
        operationWithMaps.add(new HashMap<>());
        operationWithMaps.add(new TreeMap<>());

        map = operationWithMaps.initializationMapAndShuffle(new HashMap<>());
        operationWithMaps.containsValue(map);
        operationWithMaps.containsValue(new TreeMap<>(map));

        operationWithMaps.containsKey(map);
        operationWithMaps.containsKey(new TreeMap<>(map));

        operationWithMaps.deleteByIndex(map);
        map = operationWithMaps.initializationMapAndShuffle(new HashMap<>());
        operationWithMaps.deleteByIndex(new TreeMap<>(map));
    }
}