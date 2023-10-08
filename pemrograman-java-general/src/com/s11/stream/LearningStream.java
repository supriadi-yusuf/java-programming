package com.s11.stream;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.*;

public class LearningStream {
    private static void p01CreateEmptyOrSingleStream() {

        System.out.println("====== Create Empty Or Single Stream ======");

        Stream<String> emptyStream = Stream.<String>empty();
        Stream<String> singleStream = Stream.<String>of("supri");

        String data = null;
        Stream<String> nullableStream = Stream.<String>ofNullable(data);
    }

    private static void p02CreateStreamFromArray() {

        System.out.println("\n==== Create Stream From Array ======");

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);
        Stream<String> stringStream = Stream.of("supriadi", "syafeie", "ysufu", "java", "programmer");

        String[] arrayString = {"supriadi", "syafeie", "muhammad", "yusuf"};
        Stream<String> arrayStream = Arrays.stream(arrayString);
    }

    private static void p03CreateStreamFromCollection() {

        System.out.println("\n====== Create Stream From Collection ======");

        List<String> list = List.of("supriadi", "syafeie", "yusuf");
        Stream<String> stream = list.stream();
    }

    private static void p04InfiniteStream() {

        System.out.println("\n====== Infinite Stream ======");

        // This kind of stream keep generating data, to stop the stream we have to terminate program
        Stream<String> infiniteGenerateStream = Stream.generate(() -> "supriadi syafeie yusuf");
//        infiniteGenerateStream.forEach(System.out::println);

        Stream<Integer> iterateStream = Stream.iterate(1, value -> value + 1);
//        iterateStream.forEach(System.out::println);

        Stream<Integer> iterateStream2 = Stream.iterate(1, value -> value <= 10, val -> val + 1);
        iterateStream2.forEach(System.out::println);
    }

    private static void p05treamBuilder() {

        System.out.println("\n====== Stream Builder ======");

        // we can create stream with stream builder

        Stream.Builder<String> builder = Stream.<String>builder();
        builder.accept("supriadi");
        builder.add("muhammad").add("yusuf");

        Stream<String> stringStream = builder.build();
        stringStream.forEach(System.out::println);
    }

    private static void p06StreamOperation() {

        System.out.println("\n====== Stream Operation ======");

        // we can do some operation on stream
        List<String> list = List.of("supriadi", "muhammad", "yusuf");
        Stream<String> stream = list.stream();
        Stream<String> streamUpper = stream.map(String::toUpperCase);
        streamUpper.forEach(System.out::println);
    }

    private static void p07StreamPipeline() {

        System.out.println("\n====== Stream Pipeline ======");

        // common practise is do several operations on stream
        List<String> list = List.of("supriadi", "muhammad", "yusuf");

        list.stream()
                .map(String::toUpperCase)
                .map(value -> "Mr" + value)
                .forEach(System.out::println);
    }

    private static void p08LazyEvaluation() {

        System.out.println("\n====== Lazy Evaluation ======");

        // intermediate operation vs terminal operation
        // intermediate operation creates new stream
        // intermediate operation is lazy, it means there is no data to go out from stream source
        // terminal operation trigger data to flow from stream source to last stream operation
        // intermediate operation : map
        // terminal operation : forEach
        List<String> list = List.of("supriadi", "muhammad", "yusuf");

        // intermediate operation
        Stream<String> intermediateOperationResult = list.stream()
                .map(value -> {
                    System.out.println("change " + value + " to upper case");
                    return value.toUpperCase();
                })
                .map(value -> {
                    System.out.println("add Mr. to " + value);
                    return "Mr. " + value;
                });

        // terminal operation
        intermediateOperationResult.forEach(System.out::println);
    }

    private static void p09TransformationOperation() {
        System.out.println("\n====== Transformation Operation ======");
        // transformation operation is to transform (change) data
        // there two transformation operation : map, flatMap

        // map : change data into other data
        List.of("supriadi", "muhammad", "yusuf").stream()
                .map(String::toUpperCase)
                .map(String::length)
                .forEach(System.out::println);

        // flatMap : change data into stream
        List.of("supriadi", "muhammad", "yusuf").stream()
                .flatMap(value -> Stream.of(value, value.length()))
                .flatMap(value -> Stream.of(value, value, value))
                .forEach(System.out::println);
    }

    private static void p10FilterOperation() {
        System.out.println("\n====== Filter Operation ======");

        // There two kinds of filter operation : filter and distinct
        // filter : remove data that is not match criteria
        // distinct : remove duplicate data

        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream()
                .filter(value -> value % 2 == 0)
                .forEach(System.out::println);

        List.of(1, 1, 2, 3, 3, 4, 5, 5, 5).stream()
                .distinct()
                .forEach(System.out::println);
    }

    private static void p11RetrievingOperation() {
        System.out.println("\n====== Retrieving Operation ======");

        // retrieve operation is to retrieve part of data not all data
        // Retrieve some data : limit, skip, takeWhile, dropWhile (intermediate operation)
        // Retrieve single data : findFist, findAny (terminal operation)

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 5, 4, 3, 2, 1);

        System.out.println("data : " + list);

        System.out.println("limit 5 :");

        // limit : take n first data
        list.stream()
                .limit(5)
                .forEach(System.out::println);

        System.out.println("skip 5 :");

        // skip : skip n first data
        list.stream()
                .skip(5)
                .forEach(System.out::println);

        System.out.println("take while <= 7 : ");

        // takeWhile : take data while condition is match. once unmatched condition found, the process to take data is stopped
        list.stream()
                .takeWhile(value -> value <= 7)
                .forEach(System.out::println);

        System.out.println("dropWhile < 6 : ");

        // dropWhile : ignored data while condition is match. when condition is not match again then take data
        list.stream()
                .dropWhile(value -> value < 6)
                .forEach(System.out::println);

        System.out.println("Find First : ");

        // find first is to take first data
        Optional<Integer> first = list.stream()
                .findFirst();

        first.ifPresent(System.out::println);

        System.out.println("Find Any : ");

        // find any is find any single data
        Optional<Integer> any = list.stream()
                .findAny();

        any.ifPresent(System.out::println);
    }

    private static void p12OrderingOperation() {
        System.out.println("\n====== Order Operation ======");

        // order operation is to sort data
        // there are two operation : sorted(), sorted(Comparator)

        List<String> list = List.of("supriadi", "syafeie", "muhammad", "yusuf", "java", "programmer");

        System.out.println("data : " + list);

        // sorted
        System.out.println("sorted() :");
        list.stream()
                .sorted()
                .forEach(System.out::println);

        // sorted(Comparator)
        System.out.println("sorted(Comparator) :");
        list.stream()
                .sorted(Comparator.reverseOrder()) // descending
                .forEach(System.out::println);
    }

    private static void p13AggregateOperation() {
        System.out.println("\n====== Aggregate Operation ======");

        // Aggregate operation is terminal operation
        // min(Comparator), max(Comparator), count, reduce
        // reduce operator can be used to sum and/or multiply
        List<String> names = List.of("supriadi", "syafeie", "muhammad", "yusuf", "java", "programmer");

        System.out.println("data : " + names);

        System.out.println("max :");

        Optional<String> maxValue = names.stream()
                .max(Comparator.naturalOrder());

        maxValue.ifPresent(System.out::println);

        System.out.println("min :");
        names.stream()
                .min(Comparator.naturalOrder())
                .ifPresent(System.out::println);

        System.out.println("count :");
        long count = names.stream()
                .count();
        System.out.println(count);

        // we can sum or multiply data
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println("data : " + numbers);

        System.out.println("sum :");
        Integer sumResult = numbers.stream()
                .reduce(0, (initValue, value) -> initValue + value); // 1+2+3+4+5
        System.out.println(sumResult);

        System.out.println("multiply :");
        Integer multiplyResult = numbers.stream()
                .reduce(1, (initValue, value) -> initValue * value); // 1*2*3*4*5
        System.out.println(multiplyResult);
    }

    private static void p14CheckOperation() {
        System.out.println("\n====== Check Operation ======");

        // Check operation is terminal operation. it returns boolean.
        // 3 operation : anyMatch, allMatch noneMatch

        List<String> names = List.of("supriadi", "syafeie", "muhammad", "yusuf", "java", "programmer");

        System.out.println("data : " + names);

        System.out.println("anyMatch :");
        boolean anyMatch = names.stream()
                .anyMatch(value -> value.length() == 10);
        System.out.println(anyMatch);

        System.out.println("allMatch :");
        boolean allMatch = names.stream()
                .allMatch(value -> value.length() <= 10);
        System.out.println(allMatch);

        System.out.println("noneMatch :");
        boolean noneMatch = names.stream()
                .noneMatch(value -> value.length() < 4);
        System.out.println(noneMatch);
    }

    private static void p15ForEachOperation() {
        System.out.println("\n====== For Each Operation ======");

        // For each operation has two operator : forEach and peek
        // forEach is terminal operator while peek is not.
        // both these operators

        List<String> names = List.of("supriadi", "syafeie", "muhammad", "yusuf", "java", "programmer");

        System.out.println("data : " + names);

        names.stream()
                .peek(value -> System.out.println(value + " is changed to upper case becomes " + value.toUpperCase()))
                .forEach(System.out::println);
    }

    private static void p16PrimitiveStream() {
        System.out.println("\n====== Primitive Operation ======");

        System.out.println("intStream (integer stream) : ");
        // Primitive operation is for primitive data type : int, long, double.
        IntStream.of(1, 2, 3, 4, 5, 6)
                .forEach(System.out::println);

        System.out.println("intStream 1 : ");
        IntStream.range(1, 5)
                .forEach(System.out::println);

        IntStream.Builder intStremBuilder = IntStream.builder();
        intStremBuilder.add(15).add(10).add(3);
        IntStream intStream = intStremBuilder.build();
        intStream.forEach(System.out::println);

        Stream<Integer> integerStream = IntStream.of(1, 2, 3)
                .mapToObj(value -> Integer.valueOf(value));
        integerStream.forEach(System.out::println);

        System.out.println("Long stream : ");

        LongStream.builder()
                .add(10)
                .add(5)
                .add(7)
                .build()
                .forEach(System.out::println);

        LongStream longStream = LongStream.builder()
                .add(10)
                .add(5)
                .add(7)
                .build();
        Stream<String> stringStream = longStream
                .mapToObj(value -> Long.toString(value));
        stringStream.forEach(System.out::println);

        System.out.println("Double stream : ");
        DoubleStream.of(1, 2, 3)
                .forEach(System.out::println);

        DoubleStream doubleStream = DoubleStream.of(1, 2, 3);
        Stream<Double> doubleObjStream = doubleStream.mapToObj(value -> Double.valueOf(value));
        doubleObjStream.forEach(System.out::println);

        IntStream.range(1, 100)
                .max()
                .ifPresent(System.out::println);

        System.out.println("count : " + IntStream.range(1, 100)
                .count());

        IntStream.range(1, 100)
                .average()
                .ifPresent(System.out::println);
    }

    private static void p17CollectingOperation() {
        System.out.println("\n====== Collecting Operation ======");

        // stream has operator called collect(Collector)
        // collect is terminal operator to transform stream into another data format such as set, list, map

        String[] data = {"supriadi", "syafei", "muhammad", "yusuf", "java", "programmer", "professional"};

        // create set from stream
        Stream<String> stringStream = Stream.of(data);
        Set<String> stringSet = stringStream.collect(Collectors.toSet());

        Set<String> unmodifiableStringSet = Stream.of(data)
                .collect(Collectors.toUnmodifiableSet());

        // create list from stream
        List<String> stringList = Stream.of(data)
                .collect(Collectors.toList());

        List<String> unmodifiableStringList = Stream.of(data)
                .collect(Collectors.toUnmodifiableList());

        // create map from stream
        Map<String, Integer> stringIntegerMap = Stream.of(data)
                .collect(Collectors.toMap(u -> u, String::length));

        Map<String, Integer> unmodifiableStringIntegerMap = Stream.of(data)
                .collect(Collectors.toUnmodifiableMap(u -> u, String::length));

        System.out.println(unmodifiableStringIntegerMap);
    }

    private static void p18GroupingBy() {
        System.out.println("\n====== Grouping By ======");

        // grouping will group data. it return map<key, List<>>
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        Map<String, List<Integer>> groupData = Stream.of(data)
                .collect(Collectors.groupingBy(value -> value <= 6 ? "small" : "big"));

        System.out.println(groupData);
    }

    private static void p19Partitioning() {
        System.out.println("\n====== Partition ======");

        // partition will devide data into two parts

        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        Map<Boolean, List<Integer>> partitionResult = Stream.of(data)
                .collect(Collectors.partitioningBy(value -> value > 6));

        System.out.println(partitionResult);
    }

    private static void p20ParallelStream() {
        System.out.println("\n====== Parallel Stream ======");

        // parallel stream will be executed parallel
        // we can create parallel stream using parallel() method

        System.out.println("sequence : ");

        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Stream<Integer> sequenceStream = Stream.of(data);
        sequenceStream.forEach(value -> System.out.println(Thread.currentThread().getName() + " : " + value));

        System.out.println("\nparallel :");
        Stream<Integer> parallelStream = Stream.of(data)
                .parallel();
        parallelStream.forEach(value -> System.out.println(Thread.currentThread().getName() + " : " + value));
    }

    public static void main(String[] args) {
        p01CreateEmptyOrSingleStream();
        p02CreateStreamFromArray();
        p03CreateStreamFromCollection();
        p04InfiniteStream();
        p05treamBuilder();
        p06StreamOperation();
        p07StreamPipeline();
        p08LazyEvaluation();
        p09TransformationOperation();
        p10FilterOperation();
        p11RetrievingOperation();
        p12OrderingOperation();
        p13AggregateOperation();
        p14CheckOperation();
        p15ForEachOperation();
        p16PrimitiveStream();
        p17CollectingOperation();
        p18GroupingBy();
        p19Partitioning();
        p20ParallelStream();

    }
}
