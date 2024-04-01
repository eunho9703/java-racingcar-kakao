package racingcar;

import static racingcar.Car.validate;

import java.util.List;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.toList;

public class CarFactory {
    public static final int START_SCORE = 1;

    public static List<Car> createCar(String[] carNameList) {
        validate(carNameList);
        return stream(carNameList)
                .map(carName -> new Car(carName, START_SCORE))
                .collect(toList());
    }
}
