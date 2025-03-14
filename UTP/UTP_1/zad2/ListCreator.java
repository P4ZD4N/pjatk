package zad2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListCreator<T> {

    private final List<T> list;

    public ListCreator(List<T> list) {
        this.list = list;
    }

    public static <T> ListCreator<T> collectFrom(List<T> list) {
        return new ListCreator<>(list);
    }

    public ListCreator<T> when(Predicate<T> selector) {
        List<T> filtered = new ArrayList<>();
        list.forEach(item -> {
            if (selector.test(item))
                filtered.add(item);
        });

        return new ListCreator<>(filtered);
    }

    public List<String> mapEvery(Function<T, String> mapper) {
        List<String> mapped = new ArrayList<>();
        list.forEach(item -> mapped.add(mapper.apply(item)));
        return mapped;
    }
}
