package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.toList;

public class CarFactory {
    private static Set<String> NAME_SET = new HashSet<>();
    public static final int START_SCORE = 1;

    public static List<Car> createCar(String[] carNameList) {
        return stream(carNameList)
                .map(carName -> {
                    validateDuplicateName(carName);
                    return new Car(carName, START_SCORE);
                })
                .collect(toList());
    }

    private static void validateDuplicateName(String name) {
        if (NAME_SET.contains(name)) {
            throw new IllegalArgumentException("동일한 차량 이름은 불가능합니다.");
        }
        NAME_SET.add(name);
    }
}
