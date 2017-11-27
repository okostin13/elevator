package Controllers;

import Core.Elevator;
import Core.Floor;
import Core.Person;

import java.util.List;

public class PersonController implements Controller{

    private ButtonController btn;
    private List<Person> persons;
    private List<Elevator> elevators;
    private List<Floor> floors;
    private int personsNumber;
    private int completePersonsNumber = 0;

    public PersonController(List<Person> persons, List<Elevator> elevators, ButtonController btn, List<Floor> floors) {
        this.floors = floors;
        this.persons = persons;
        this.elevators = elevators;
        this.btn = btn;
        personsNumber = persons.size();
    }

    public void call() {
        for (Person person : persons) {
            btn.callFormFloor(person.getCurrentFloor(),person);
        }
    }

    public boolean isCompleted() {
        if (completePersonsNumber == personsNumber)
            return true;
        else
            return false;
    }

    public void action() {
        for (Person person : persons) {
            if (!person.isOntarget()) {

                if (!person.isOnWay()) {
                    for (Elevator elevator : elevators) {
                        if (elevator.getCurrentFloor() == person.getCurrentFloor() && elevator.isStaying() && !person.isOnWay()) {
                            if (elevator.getPersonCount() == 0) {
                                if (person.enter(elevator, floors.get(person.getCurrentFloor() - 1),true)) {
                                    btn.cancelCall(person.getCurrentFloor());
                                }
                            }
                            else {
                                if (person.enter(elevator, floors.get(person.getCurrentFloor() - 1),false)) {
                                    btn.cancelCall(person.getCurrentFloor());
                                }
                            }
                        }
                    }

                } else {
                    for (Elevator elevator : elevators) {
                        if (elevator.getCurrentFloor() == person.getTargetFloor() && elevator.isStaying() && elevator.getPersons().contains(person) && person.isOnWay()) {
                            person.goOut(elevator, floors.get(person.getTargetFloor() - 1));
                            completePersonsNumber++;
                        }
                    }
                }
            }
        }
    }
}