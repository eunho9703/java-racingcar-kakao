package racingcar;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static racingcar.Car.START_SCORE;
import static racingcar.Car.updatePosition;

public class Race {
    List<Car> carList;

    public Race(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getWinner() {
        int maxScore = getMaxScore();

        return this.carList
                .stream()
                .filter(car -> isMaxScoreCar(car, maxScore))
                .collect(toList());
    }

    public static boolean isMaxScoreCar(Car car, int maxScore) {
        return car.getPosition() == maxScore;
    }

    private int getMaxScore() {
        return this.carList
                .stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(START_SCORE);
    }

    public static List<Car> updateCarByNum(List<Car> initCarList, List<Integer> randomNumList) {
        for (int i = 0; i < initCarList.size(); i++) {
            updatePosition(initCarList.get(i), randomNumList.get(i));
        }
        return initCarList;
    }

}