package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private int progress;


    public Car(String name) {
        final int CAR_NAME_MAX_LENGTH = 5;
        if (name.length() > CAR_NAME_MAX_LENGTH)
            throw new IllegalArgumentException();
        this.name = name;
    }

    public int getProgress() {
        return progress;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        progress++;
    }

    public static List<Car> toCarList(String[] carNameTokens) {
        final List<Car> cars = new ArrayList<>();
        for (String carName : carNameTokens)
            cars.add(new Car(carName));
        return cars;
    }

}
