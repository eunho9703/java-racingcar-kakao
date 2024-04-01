package racingcar;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void isUpdateCarScore_ShouldIncreaseScoreGreaterOrEqualWithFour(int num) {
        Car car = new Car("name", 0);
        Car expectedMove = new Car("name", 1);
        Car afterMove = Car.updatePosition(car, num);
        assertThat(expectedMove).isEqualTo(afterMove);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void isUpdateCarScore_ShouldNotIncreaseScoreLessOrEqualWithThree(int num) {
        Car car = new Car("name", 0);
        Car expectedMove = new Car("name", 0);
        Car afterMove = Car.updatePosition(car, num);
        assertThat(expectedMove).isEqualTo(afterMove);
    }

    @Test
    void isGetCar_ShouldReturnSplitCarList() {
        String carString = "pobi,crong,honux";
        String[] split = carString.split(",");
        List<Car> carList = CarFactory.createCar(split);

        List<Car> expectedCarList = new ArrayList<>();
        expectedCarList.add(new Car("pobi", Car.START_SCORE));
        expectedCarList.add(new Car("crong", Car.START_SCORE));
        expectedCarList.add(new Car("honux", Car.START_SCORE));

        assertThat(carList).isEqualTo(expectedCarList);
    }

    @Test
    void isGetCar_ShouldThrowIllegalArgumentExceptionWithOverFive() {
        String carString = "longNamehaha,a";
        String[] split = carString.split(",");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Car.validate(split);
                }).withMessage("차량 이름은 5자를 넘어서는 안됩니다.");
    }

}
