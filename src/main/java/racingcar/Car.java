package racingcar;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Car {
    public static final int START_SCORE = 1;
    private static final int MAX_CARNAME = 5;
    private static final int MIN_RANDNUM = 3;
    private static final String DASH_PRINT_POSITION = "-";

    private int position;
    private final String name;

    public Car(String name, int position) {
        validateCarNameLength(name);
        this.name = name;
        this.position = position;
    }

    private static void validateCarNameLength(String CarName) {
        if (CarName.length() > MAX_CARNAME) {
            throw new IllegalArgumentException("차량 이름은 5자를 넘어서는 안됩니다.");
        }
    }

    public static Car updatePosition(Car car, int num) {
        if (num > MIN_RANDNUM) {
            car.position++;
        }
        return new Car(car.name, car.position);
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public static String makeCarPrint(Car car) {
        return car.name + " : " + makeDash(car.position);
    }

    private static String makeDash(int carScore) {
        return DASH_PRINT_POSITION.repeat(carScore);
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

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
