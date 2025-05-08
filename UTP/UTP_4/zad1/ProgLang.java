package zad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Predicate;

public class ProgLang {

    private final File file;

    public ProgLang(String filePath) {
        file = new File(filePath);
    }

    public Map<String, Set<String>> getLangsMap() throws FileNotFoundException {
        Map<String, Set<String>> langsMap = new LinkedHashMap<>();

        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String nextLine = reader.nextLine();
            String[] splitNextLine = nextLine.split("\t");
            String programmingLanguage = splitNextLine[0];
            Set<String> programmers = new LinkedHashSet<>(Arrays.asList(splitNextLine).subList(1, splitNextLine.length));
            langsMap.put(programmingLanguage, programmers);
        }
        reader.close();

        return langsMap;
    }

    public Map<String, Set<String>> getProgsMap() throws FileNotFoundException {
        Map<String, Set<String>> progsMap = new LinkedHashMap<>();

        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String nextLine = reader.nextLine();
            String[] splitNextLine = nextLine.split("\t");
            for (int i = 1; i < splitNextLine.length; i++) {
                if (progsMap.get(splitNextLine[i]) != null && !splitNextLine[i].isEmpty()) {
                    progsMap.get(splitNextLine[i]).add(splitNextLine[0]);
                    continue;
                }

                progsMap.put(splitNextLine[i], new LinkedHashSet<>(Collections.singletonList(splitNextLine[0])));
            }
        }
        reader.close();

        return progsMap;
    }

    public Map<String, Set<String>> getLangsMapSortedByNumOfProgs() throws FileNotFoundException {
        List<Map.Entry<String, Set<String>>> list = new ArrayList<>(getLangsMap().entrySet());
        list.sort(Comparator.comparing((Map.Entry<String, Set<String>> e) -> e.getValue().size()).reversed());
        return getResultMap(list);
    }

    public Map<String, Set<String>> getProgsMapSortedByNumOfLangs() throws FileNotFoundException {
        List<Map.Entry<String, Set<String>>> list = new ArrayList<>(getProgsMap().entrySet());
        list.sort(
            Comparator
                .comparing((Map.Entry<String, Set<String>> e) -> e.getValue().size(), Comparator.reverseOrder())
                .thenComparing(Map.Entry::getKey)
        );
        return getResultMap(list);
    }

    private Map<String, Set<String>> getResultMap(List<Map.Entry<String, Set<String>>> list) {
        Map<String, Set<String>> result = new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public Map<String, Set<String>> getProgsMapForNumOfLangsGreaterThan(int n) throws FileNotFoundException {
        Map<String, Set<String>> progsMap = new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> entry : getProgsMap().entrySet()) {
            if (entry.getValue().size() > n) {
                progsMap.put(entry.getKey(), entry.getValue());
            }
        }

        return progsMap;
    }

    public <K, V> Map<K, V> sorted(Map<K, V> mapToSort, Comparator<Map.Entry<K, V>> comparator) {
        List<Map.Entry<K, V>> list = new ArrayList<>(mapToSort.entrySet());
        list.sort(comparator);

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


    public <K, V> Map<K, V> filtered(Map<K, V> mapToFilter, Predicate<Map.Entry<K, V>> predicate) {
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : mapToFilter.entrySet()) {
            if (predicate.test(entry)) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}
