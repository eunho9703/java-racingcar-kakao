package racingcar;

import java.util.ArrayList;
import java.util.List;


import static java.util.stream.Collectors.*;
import static racingcar.view.ResultView.printCars;

public class RacingGame {

    private final String carNames;
    private final int tryNo;
    private int gameCount;

    public List<Car> carList = new ArrayList<>();

    public RacingGame(String carNames, int tryNo) {
        this.carNames = carNames;
        this.tryNo = tryNo;
        makeCar();
        printCars(carList);
    }

    private void makeCar() {
        String[] split = carNames.split(",");
        carList = Car.createCar(split);
    }

    public void race() {
        List<Integer> ranNumList = RandomGenerator.makeRanNumList(tryNo);
        Race.updateCarByNum(carList, ranNumList);
        gameCount++;
    }


    public boolean isEnd() {
        return tryNo == gameCount;
    }

    public List<Car> getCars() {
        return carList;
    }


    public List<String> getWinners() {
        Race race = new Race(carList);
        return race.getWinner()
                .stream()
                .map(Car::getName)
                .collect(toList());
    }
}
