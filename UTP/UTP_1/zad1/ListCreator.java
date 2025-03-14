/**
 *
 *  @author Chudy Wiktor S30359
 *
 */

package zad1;


import java.util.ArrayList;
import java.util.List;

public class ListCreator<T> { // Uwaga: klasa musi być sparametrtyzowana

    private List<T> list;

    public ListCreator(List<T> list) {
        this.list = list;
    }

    public static <T> ListCreator<T> collectFrom(List<T> list) {
        return new ListCreator<>(list);
    }

    public ListCreator<T> when(Selector<T> selector) {

        List<T> filteredList = new ArrayList<>();

        for (T item : list) {
            if (selector.select(item)) {
                filteredList.add(item);
            }
        }

        this.list = filteredList;

        return this;
    }

    public <U> List<U> mapEvery(Mapper<T, U> mapper) {
        List<U> resultList = new ArrayList<>();

        for (T item : list) {
            resultList.add(mapper.map(item));
        }

        return resultList;
    }
}
