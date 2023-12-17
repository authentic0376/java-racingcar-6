package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Game {
    private final List<Car> cars;
    private final int operationCnt;

    public int getOperationCnt() {
        return operationCnt;
    }


    public void printProgress() {
        for (Car car : cars)
            System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getProgress()));
    }

    public Game(List<Car> cars, int operationCnt) {
        this.cars = cars;
        this.operationCnt = operationCnt;
    }

    public void executeRound() {
        for (Car car : cars) {
            if (carMoveForwardCondition())
                car.moveForward();
        }
    }

    private boolean carMoveForwardCondition() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private void sortCarsByProgress() {
        cars.sort((Car a, Car b) -> Integer.compare(b.getProgress(), a.getProgress()));
    }

    public List<Car> getWinners() {
        sortCarsByProgress();

        final Car firstWinner = cars.get(0);
        final int WINNER_PROGRESS = firstWinner.getProgress();
        int winnerCnt = 1;

        for (; winnerCnt < cars.size(); winnerCnt++)
            if (WINNER_PROGRESS != cars.get(winnerCnt).getProgress())
                break;

        return cars.subList(0, winnerCnt);
    }
}
