package home_work2309;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordUtils {

    @SneakyThrows
    public static long numberOfWords(File file) {

        BufferedReader reader = new BufferedReader(new FileReader(file));

        Stream<String> lines = reader.lines();

        return lines.
                flatMap(line -> Arrays.stream(line.split(" ")))
                .count();

    }

    @SneakyThrows
    public static List<String> mostPopular(File file, int x) {

        BufferedReader reader = new BufferedReader(new FileReader(file));

        //get words from file
        Stream<String> items = reader.lines()
                .flatMap(line -> Arrays.stream(line.split(" ")));

        //add words to list
        List<String> words = items.collect(Collectors.toList());

        //add words and amount of duplicates to map
        Map<String, Long> dups =
                words.stream()
                        .collect(Collectors
                                .groupingBy(Function
                                        .identity(),Collectors.counting()));

        //get all that match the inputted x (value) and add the word (key) to list
        List<String>results = dups.entrySet()
                .stream()
                .filter(i -> x == (i.getValue()))
                .map(map->map.getKey())
                .collect(Collectors.toList());

       return results;
    }
}

