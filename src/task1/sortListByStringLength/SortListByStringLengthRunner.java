package task1.sortListByStringLength;

import java.util.Arrays;
import java.util.List;

public class SortListByStringLength {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("4321", "21", "321", "54321", "1", "22", "", "654321", "55321");
        Sorter sorter = new Sorter();

        sorter.setListForSorting(list);
        sorter.sorting();
        System.out.println(sorter.getListForSorting());
    }
}
