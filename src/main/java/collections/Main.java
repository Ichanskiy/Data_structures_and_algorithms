package collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("tesla S", 2010));
        carList.add(new Car("tesla X", 2009));
        carList.add(new Car("tesla 3", 2018));
        carList.add(new Car("tesla Y", 2019));

        Collections.sort(carList, new CarNameComparator());

        for (Car aCarList : carList) {
            System.out.println("carList = " + aCarList);
        }
        
        TreeSet<Car> cars = new TreeSet<>(new CarNameComparator());
        cars.add(new Car("tesla S", 2010));
        cars.add(new Car("tesla X", 2009));
        cars.add(new Car("tesla 3", 2018));
        cars.add(new Car("tesla Y", 2019));

        System.out.println("cars = " + cars);
    
    }
}
