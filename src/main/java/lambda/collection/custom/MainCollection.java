package lambda.collection.custom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MainCollection {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("sergey", 10));
        people.add(new Person("lol", 120));
        people.add(new Person("aek", 110));
        people.add(new Person("def", 20));
        people.add(new Person("def", 30));

        people.stream().sorted(Comparator.comparing(Person::getAge)).filter(person -> person.getAge() > 28).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("");
        people.stream().filter(person -> person.getAge() > 28).sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).forEach(System.out::println);

        System.out.println("---------");
        people.stream().filter(person -> person.getAge() > 28).map(Person::getAge).forEach(System.out::println);

        System.out.println("average");
        System.out.println(people.stream().filter(person -> person.getAge() > 100).mapToDouble(Person::getAge).average().getAsDouble());

        System.out.println("maxValue");
        int maxValue = people.stream().filter(Objects::nonNull).map(Person::getAge).max(Integer::compareTo).get();
        System.out.println("maxValue = " + maxValue);

        System.out.println("count");
        long count = people.parallelStream().filter(person -> person.getName().equals("def")).count();
        System.out.println("count = " + count);

        System.out.println("limit");
        System.out.println(people.stream().limit(2).collect(Collectors.toList()));

        System.out.println("---------");
        List<Person> people1 = people.stream().filter(person -> person.getAge() > 28).map(person -> {
            person.setAge(10);
            return person;
        }).collect(Collectors.toList());
        System.out.println("people age = 10 = " + people1);

        List<Person> people2 = people.stream().filter(person -> person.getAge() > 9).peek(person -> person.setAge(10)).collect(Collectors.toList());
        System.out.println("people age = 10 = " + people2);
    }
}
