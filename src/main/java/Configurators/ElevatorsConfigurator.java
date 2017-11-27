package Configurators;

import Core.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElevatorsConfigurator implements Configurator {


    private List<Shaft> shafts;
    private Building building;
    private List<Elevator> elevators;

    public ElevatorsConfigurator(List<Shaft> shafts, Building building) {
        this.shafts = shafts;
        this.building = building;
    }

    private Scanner in = new Scanner(System.in);

    private void configElevator(Shaft shaft) {
        Elevator elevator = new Elevator();
        System.out.println("Elevator " + shaft.getNumber() + " config");
        configStartFloor(elevator);
        configWeight(elevator);
        elevator.setPersonCount(0);
        elevator.setLeftPadding(shaft.getLeftPadding() + 1);
        elevators.add(elevator);
    }

    public List<Elevator> configure() {
        elevators = new ArrayList<>();
        for (Shaft shaft : shafts) {
            configElevator(shaft);
        }
        return elevators;
    }

    private void configStartFloor(Elevator elevator) {
        System.out.println("Input starting floor" + "(between 1 and " + building.getFloorCount() + ")");
        int temp = in.nextInt();
        if (temp > 0 && temp <= building.getFloorCount()) {
            elevator.setHeight((building.getHeight() - 5) - (temp - 1) * (building.getHeight() - 4) / building.getFloorCount());
            elevator.setCurrentFloor(temp);
        } else {
            System.out.println("Invalid input");
            configStartFloor(elevator);
        }

    }

    private void configWeight(Elevator elevator) {
        System.out.println("Input permissible weight");
        int temp = in.nextInt();
        if (temp > 0)
            elevator.setPermissibleWeight(temp);
        else {
            System.out.println("Incorrect input");
            configWeight(elevator);
        }
    }
}
