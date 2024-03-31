package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.toList;

public class Car {
    public static final int START_SCORE = 1;
    private int position;
    private final String name;

    public Car(String name, int position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static List<Car> getCar(String[] carNameList) {
        return stream(carNameList)
                .map(carName -> new Car(carName, START_SCORE))
                .collect(toList());
    }


    public static List<Car> createCar(String[] carNameList) {
        return stream(carNameList)
                .map(carName -> {
                    return new Car(carName, START_SCORE);
                })
                .collect(toList());
    }

    public static void validate(String str) {
        String[] carNameList = str.split(",");
        HashSet<String> checker = new HashSet<>();

        for (String carName : carNameList) {
            validateCarNameLength(carName);
            checker.add(carName);
        }

        if (checker.size() != carNameList.length) {
            throw new IllegalArgumentException("동일한 차량 이름은 불가능합니다.");
        }
    }

    private static void validateCarNameLength(String str) {
        if (str.length() > 5) {
            throw new IllegalArgumentException("차량 이름은 5자를 넘어서는 안됩니다.");
        }
    }


    public static Car updatePosition(Car car, int num) {
        if (num > 3) {
            car.position++;
        }
        return new Car(car.name, car.position);
    }


    public static String makeCarPrint(Car car) {
        String stringBuilder = car.name +
                " : " +
                makeDash(car.position);

        return stringBuilder;

    }

    private static String makeDash(int carScore) {
        String dash = "-";
        return dash.repeat(carScore);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;

        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
