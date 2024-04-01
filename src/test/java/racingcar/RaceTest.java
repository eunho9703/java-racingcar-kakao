package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    @Test
    void isGetWinner_ShouldReturnMaxCountCarList() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("one", 5));
        carList.add(new Car("two", 4));
        carList.add(new Car("three", 5));
        carList.add(new Car("four", 2));

        List<Car> expectedWinner = new ArrayList<>();
        ;
        expectedWinner.add(new Car("one", 5));
        expectedWinner.add(new Car("three", 5));

        Race race = new Race(carList);

        List<Car> winnerList = race.getWinner();
        assertThat(winnerList).isEqualTo(expectedWinner);
    }

    @Test
    void isUpdateCarList_ShouldReturnCarListWithUpdatedScore() {
        List<Integer> randomNumList = new ArrayList<>();
        randomNumList.add(4);
        randomNumList.add(2);
        randomNumList.add(7);

        List<Car> initCarList = new ArrayList<>();
        initCarList.add(new Car("pobi", 0));
        initCarList.add(new Car("crong", 0));
        initCarList.add(new Car("honux", 0));

        List<Car> updateCarList = Race.updateCarByNum(initCarList, randomNumList);

        List<Car> expectedCarList = new ArrayList<>();
        expectedCarList.add(new Car("pobi", 1));
        expectedCarList.add(new Car("crong", 0));
        expectedCarList.add(new Car("honux", 1));

        assertThat(updateCarList).isEqualTo(expectedCarList);
    }

}