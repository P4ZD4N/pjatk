/**
 *
 *  @author Chudy Wiktor S30359
 *
 */

package zad3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> words = new BufferedReader(new InputStreamReader(
                new URL("http://wiki.puzzlers.org/pub/wordlists/unixdict.txt").openStream()))
                .lines().collect(Collectors.toList());

        words.stream()
                .collect(Collectors.groupingBy(w -> w.chars()
                        .sorted()
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString()))
                .values().stream()
                .filter(g -> g.size() > 1)
                .collect(Collectors.groupingBy(List::size))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .ifPresent(e -> e.getValue().forEach(g -> System.out.println(String.join(" ", g))));
    }
}
