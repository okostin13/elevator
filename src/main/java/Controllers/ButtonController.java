package Controllers;

import Core.Direction;
import Core.Elevator;
import Core.Person;

import java.util.List;

public class ButtonController implements Controller{

    private List<Person> persons;
    private List<Elevator> elevators;

    public ButtonController(List<Person> persons, List<Elevator> elevators) {
        this.persons = persons;
        this.elevators = elevators;
    }

    public void callFormFloor(Integer floorNumber, Person person) {
        for (Elevator elevator : elevators) {
            if (!elevator.getPeronsCallers().contains(person)) {
                if (elevator.getTargetFloors().size() == 0 || elevator.getDirection() == Direction.none) {
                    elevator.addTargetFloor(floorNumber);
                    elevator.getPeronsCallers().add(person);
                } else if (elevator.getTargetFloors().get(0) <= floorNumber && elevator.getDirection() == Direction.down && floorNumber <= elevator.getCurrentFloor()) {
                    elevator.addTargetFloor(floorNumber);
                    elevator.getPeronsCallers().add(person);
                } else if (elevator.getTargetFloors().get(0) >= floorNumber && elevator.getDirection() == Direction.up && floorNumber >= elevator.getCurrentFloor()) {
                    elevator.addTargetFloor(floorNumber);
                    elevator.getPeronsCallers().add(person);
                }
            }
        }
    }

    public void cancelCall(Integer number){
        for (Elevator elevator:elevators){
            elevator.getTargetFloors().remove(number);
        }
    }


}
