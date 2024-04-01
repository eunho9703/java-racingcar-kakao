package racingcar;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static racingcar.Car.updatePosition;

public class Race {
    private final List<Car> carList;

    public Race(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getWinner() {
        int maxPosition = getMaxPosition();

        return this.carList
                .stream()
                .filter(car -> Car.isMaxPosition(car, maxPosition))
                .collect(toList());
    }

    private int getMaxPosition() {
        return this.carList
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("차 리스트가 비어있습니다."));
    }

    public static List<Car> updateCarByNum(List<Car> initCarList, List<Integer> randomNumList) {
        for (int i = 0; i < initCarList.size(); i++) {
            updatePosition(initCarList.get(i), randomNumList.get(i));
        }
        return initCarList;
    }
}