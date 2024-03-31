package racingcar;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {
    @Test
    void isMakeRanNumList_ShouldReturnRandomNumListByCarSize() {
        String carString = "pobi,crong,honux";
        String[] split = carString.split(",");
        int expectedSize = split.length;

        List<Integer> randomNumList = RandomGenerator.makeRanNumList(split.length);
        assertThat(randomNumList.size()).isEqualTo(expectedSize);
    }
}