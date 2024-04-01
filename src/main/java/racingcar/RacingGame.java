package racingcar;

import java.util.ArrayList;
import java.util.List;


import static java.util.stream.Collectors.*;
import static racingcar.view.ResultView.printCars;

public class RacingGame {

    private final String carNames;
    private int tryNo;

    private List<Car> carList = new ArrayList<>();

    public RacingGame(String carNames, int tryNo) {
        this.carNames = carNames;
        this.tryNo = tryNo;
        makeCar();
        printCars(carList);
    }

    private void makeCar() {
        String[] split = carNames.split(",");
        carList = CarFactory.createCar(split);
    }

    public void race() {
        List<Integer> ranNumList = RandomGenerator.makeRanNumList(carList.size());
        Race.updateCarByNum(carList, ranNumList);
        tryNo--;
    }

    public boolean isEnd() {
        //return tryNo == gameCount;
        return tryNo == 0;
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
