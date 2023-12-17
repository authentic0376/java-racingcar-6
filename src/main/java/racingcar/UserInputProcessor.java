package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserInputProcessor {

    private int operationCnt;
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public int getOperationCnt() {
        return operationCnt;
    }

    public void processOperationCntStr(String operationCntStr) {
        try {
            operationCnt = Integer.parseInt(operationCntStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void processCarNameCSV(String carNameCSV) {
        String[] carNameTokens = carNameCSV.split(",");
        cars = Car.toCarList(carNameTokens);
    }
}
