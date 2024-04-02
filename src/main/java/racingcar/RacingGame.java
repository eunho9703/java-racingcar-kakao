package racingcar;

import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.Race;
import racingcar.model.RandomGenerator;

import java.util.ArrayList;
import java.util.List;


import static java.util.stream.Collectors.*;
import static racingcar.view.ResultView.printCars;

public class RacingGame {
    private static final int INITIAL_TRY_NO = 0;

    private List<String> carNames;
    private int tryNo;

    private List<Car> cars = new ArrayList<>();

    public RacingGame(List<String> carNames, int tryNo) {
        this.carNames = carNames;
        this.tryNo = tryNo;
        makeCar();
        printCars(cars);
    }

    private void makeCar() {
        cars = CarFactory.createCar(carNames);
    }

    public void race() {
        List<Integer> ranNumList = RandomGenerator.makeRanNumList(cars.size());
        Race.updateCarByNum(cars, ranNumList);
        tryNo--;
    }

    public boolean isEnd() {
        return tryNo == INITIAL_TRY_NO;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        Race race = new Race(cars);
        return race.getWinner()
                .stream()
                .map(Car::getName)
                .collect(toList());
    }
}
