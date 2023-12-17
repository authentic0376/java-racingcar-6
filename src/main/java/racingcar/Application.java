package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserInputProcessor inputProcessor = new UserInputProcessor();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputProcessor.processCarNameCSV(Console.readLine());
        final List<Car> cars = inputProcessor.getCars();

        System.out.println("시도할 회수는 몇회인가요?");
        inputProcessor.processOperationCntStr(Console.readLine());
        final int operationCnt = inputProcessor.getOperationCnt();

        Game game = new Game(cars, operationCnt);

        for (int i = 0; i < game.getOperationCnt(); i++) {
            game.executeRound();
            game.printProgress();
            System.out.println();
        }

        final List<Car> winners = game.getWinners();
        System.out.printf("최종 우승자 : %s", winners.stream().map(Car::getName).collect(Collectors.joining(", ")));


    }
}
