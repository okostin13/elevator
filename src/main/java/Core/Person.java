package Core;

public class Person implements Drawable {
    private int currentFloor;
    private int targetFloor;
    private int weight;
    private Direction direction;
    private boolean isOnWay=false;
    private boolean isOntarget=false;

    public boolean enter(Elevator elevator,Floor floor,boolean priority) {
        if (elevator.checkCapacity(weight)) {
            elevator.setWaitingTime(10);
            elevator.getPersons().add(this);
            isOnWay = true;
            elevator.setPersonCount(elevator.getPersonCount() + 1);
            elevator.setCurrentWeight(elevator.getCurrentWeight() + weight);
            floor.setPersonsCount(floor.getPersonsCount() - 1);
            if (!priority) {
                elevator.addTargetFloor(targetFloor);
            } else {
                elevator.addPriorityTargetFloor(targetFloor);
            }
            return true;
        } else return false;
    }

    public boolean isOnWay() {
        return isOnWay;
    }

    public void setOnWay(boolean onWay) {
        isOnWay = onWay;
    }

    public void goOut(Elevator elevator, Floor floor){

        elevator.setWaitingTime(10);
        elevator.getPersons().remove(this);
        isOnWay=false;
        elevator.setPersonCount(elevator.getPersonCount()-1);
        elevator.setCurrentWeight(elevator.getCurrentWeight()-weight);
        elevator.getTargetFloors().remove((Integer) floor.getNumber());
        floor.setCompletedPersonsCount(floor.getCompletedPersonsCount()+1);
        isOntarget=true;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isOntarget() {
        return isOntarget;
    }

    public void setOntarget(boolean ontarget) {
        isOntarget = ontarget;
    }
}
