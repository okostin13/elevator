package Controllers;

import Core.Elevator;
import Core.Floor;

import java.util.List;

public class ElevatorController implements Controller{

    private List<Elevator> elevators;

    private List<Floor> floors;

    public ElevatorController(List<Elevator> elevators, List<Floor> floors) {
        this.elevators = elevators;
        this.floors = floors;
    }

    public void action(){
        checkFloor();

        for (Elevator elevator:elevators){
            elevator.move();
        }

    }

    private void checkFloor() {
        for (Elevator elevator : elevators) {
            for (Floor floor : floors) {
                if (elevator.getHeight() == (floor.getHeight() -2) && elevator.getTargetFloors().contains(floor.getNumber())) {

                    elevator.setCurrentFloor(floor.getNumber());
                    elevator.setStaying(true);
                }
            }
        }
    }
    public List<Elevator> getElevators() {
        return elevators;
    }

    public void setElevators(List<Elevator> elevators) {
        this.elevators = elevators;
    }
}
