package lambda.collection.book;


import java.awt.*;
import java.util.List;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {
        int a = 10;
        Button button = new Button();
        button.addActionListener(e -> System.out.println("test"));
        BinaryOperator<Long> add = (х, у) -> х + у + a;
        System.out.println(add.apply(1L, 2L));
        Predicate<Integer> atLeastS = х -> х > 5;
        boolean b = atLeastS.test(10);
        BinaryOperator<Integer> binaryOperator = (aLong, aLong2) -> aLong2 + aLong2;
        binaryOperator.apply(10, 19);
        System.out.println("sda");
        System.out.println("-------------------------");
        testStream();
        testMap();
        testFlatMap();
        testMinMax();
        testReduce();
        System.out.println(maxLength(new ArrayList<>(Arrays.asList("123", "1234", "1", "12345"))));
    }

    private static void testStream() {
        List<Artist> artistList = new ArrayList<>(Arrays.asList(new Artist("test1"), new Artist("test2")));
        artistList
                .stream()
                .filter(artist -> {
                    System.out.println(artist);
                    return artist.getName().endsWith(String.valueOf(2));
                })
                .collect(toList());
    }

    private static void testMap() {
        List<String> collected = Stream.of("a", "Ь", "hello")
                .map(string -> string.toUpperCase())
                .collect(toList());
        for (String s : collected) {
            System.out.println("s = " + s);
        }
    }

    private static void testFlatMap() {
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(toList());
        for (Integer integer : together) {
            System.out.println("integer = " + integer);
        }
    }

    private static void testMinMax() {
        List<Artist> artists = new ArrayList<>(Arrays
                .asList(new Artist("test1", 55), new Artist("test2", 39)));
        Artist max = artists.stream().max(Comparator.comparing(artist -> artist.getAge())).get();
        Artist min = artists.stream().min(Comparator.comparing(artist -> artist.getAge())).get();
        System.out.println("max = " + max.getName());
        System.out.println("min = " + min.getName());
    }

    private static void testReduce() {
//        but not user reduce to sum - you must use sum
        int sum = Stream.of(1, 2, 3).reduce(0, (integer, integer2) -> integer + integer2);
        System.out.println("sum = " + sum);
    }

    private static void exercise1() {
        Album albums = new Album("The grin grey", new ArrayList<>(), new ArrayList<>());
        Set<String> natGrups = albums.getMusicianList()
                .stream()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(artist -> artist.getNationality())
                .collect(toSet());
    }

    private Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        for (Album album : albums) {
            for (Track track : album.getTrackList()) {
                if (track.getLength() > 60) {
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }

    private Set<String> findLongTracksRefactor(List<Album> albums) {
        return albums.stream()
                .flatMap(album -> album.getTrackList().stream())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .collect(Collectors.toSet());
    }

    private void exercise2(List<Artist> artists) {
        int totalMembers = 0;
        for (Artist artist : artists) {
            Stream<Artist> members = artist.getMembers();
            totalMembers += members.count();
        }
        //refactor
        totalMembers = (int) artists.stream()
                .map(Artist::getMembers)
                .count();
    }

    private static String maxLength(List<String> strings) {
        return strings.stream().max(Comparator.comparing(String::length)).get();
    }

    private static void primitives(Album album) {
        IntSummaryStatistics trackLengthStats = album.getTrackList()
                .stream()
                .mapToInt(track -> track.getLength())
                .summaryStatistics();
        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                trackLengthStats.getMax(),
                trackLengthStats.getMin(),
                trackLengthStats.getAverage(),
                trackLengthStats.getSum());
    }

    private Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
        return artists.collect(partitioningBy(Artist::isSolo));
    }

    private Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
        return albums.collect(groupingBy(Album::getMainMusician));
    }

    private static double[] imperativeInitilize(int size) {
        double[] values = new double[size];
        for (int i = 0; i < values.length; i++)
            values[i] = i;
        return values;
    }

    // method refactor
    public static double[] imperativeInitilizeRefactor(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i);
        return values;
    }

    public static void peek(Album album) {
        Set<String> nationality = album.getMusicianList()
                .stream()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(Artist::getNationality)
                .peek(s -> System.out.println("s = " + s))
                .collect(toSet());

    }
}