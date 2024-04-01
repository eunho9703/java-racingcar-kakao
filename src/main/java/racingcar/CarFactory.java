package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.toList;

public class CarFactory {

    private static final int START_SCORE = 1;

    public static List<Car> createCar(String[] carNameList) {
        validateDuplicateName(asList(carNameList));

        return stream(carNameList)
                .map(carName -> {
                    return new Car(carName, START_SCORE);
                })
                .collect(toList());
    }

    private static void validateDuplicateName(List<String> nameList) {
        Set<String> nameSet = Set.copyOf(nameList);

        if (nameList.size() != nameSet.size()) {
            throw new IllegalArgumentException("동일한 차량 이름은 불가능합니다.");
        }

    }
}
