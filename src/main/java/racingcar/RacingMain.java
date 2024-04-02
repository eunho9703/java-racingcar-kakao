package racingcar;

import racingcar.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import static java.util.Arrays.asList;


public class RacingMain {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        ResultView.printGameStart();
        String[] split = carNames.split(",");
        RacingGame racingGame = new RacingGame(asList(split), tryNo);

        while (!racingGame.isEnd()) {
            racingGame.race();
            ResultView.printCars(racingGame.getCars());
        }

        ResultView.printWinners(racingGame.getWinners());
    }
}