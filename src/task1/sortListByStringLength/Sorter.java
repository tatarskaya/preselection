package task1.sortListByStringLength;

import java.util.List;

public class Sorter {

    private List<String> listForSorting;

    public List<String> getListForSorting() {
        return listForSorting;
    }

    public void setListForSorting(List<String> listForSorting) {
        this.listForSorting = listForSorting;
    }

    public void sorting() {
        String previous;
        String current;
        String tmp;
        int countReversal;
        int itemsToVerify = listForSorting.size();

        do {
            countReversal = 0;
            for (int i = 1; i < itemsToVerify; i++) {
                previous = listForSorting.get(i - 1);
                current = listForSorting.get(i);
                try {
                    countReversal = swapElements(previous, current, countReversal, i);
                }
                catch (NullPointerException e) {
                    System.out.println("The list is contained Null element. The sorting is impossible.");
                    return;
                }
            }
            itemsToVerify--;
        } while (countReversal > 0);
    }

    private int swapElements(String previous, String current, int countReversal, int i) {
        String tmp;
        if (previous.length() > current.length()) {
            tmp = previous;
            listForSorting.set(i - 1, current);
            listForSorting.set(i, tmp);
            countReversal++;
        }
        return countReversal;
    }
}
