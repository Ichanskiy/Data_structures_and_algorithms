package lambda.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainCollection {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("sergey", 10));
        people.add(new Person("lol", 120));
        people.add(new Person("aek", 110));
        people.add(new Person("def", 20));

        people.stream().sorted(Comparator.comparing(Person::getAge)).filter(person -> person.getAge() > 28).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("");
        people.stream().filter(person -> person.getAge() > 28).sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).forEach(System.out::println);

        System.out.println("---------");
        people.stream().filter(person -> person.getAge() > 28).map(Person::getAge).forEach(System.out::println);
    }

}
