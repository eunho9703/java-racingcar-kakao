package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private static final Random randomScore = new Random();

    private static int makeRanNum() {
        return randomScore.nextInt(10);
    }

    public static List<Integer> makeRanNumList(int trialNum) {
        List<Integer> randomNumList = new ArrayList<>();

        for (int i = 0; i < trialNum; i++) {
            randomNumList.add(makeRanNum());
        }
        return randomNumList;
    }
}
