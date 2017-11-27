package Core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Elevator implements Drawable {

    private int currentFloor;
    private List<Integer> targetFloors = new ArrayList<>();
    private int height;
    private int leftPadding;
    private int  permissibleWeight;
    private int  personCount;
    private List<Person> peronsCallers =new ArrayList<>();
    private List<Person> persons = new ArrayList<>();
    private Direction direction;
    private int waitingTime;
    private boolean isStaying=true;
    private int currentWeight=0;

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLeftPadding() {
        return leftPadding;
    }

    public void setLeftPadding(int leftPadding) {
        this.leftPadding = leftPadding;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public int getPermissibleWeight() {
        return permissibleWeight;
    }

    public void setPermissibleWeight(int permissibleWeight) {
        this.permissibleWeight = permissibleWeight;
    }



    public boolean checkCapacity(int weight){
        if (currentWeight+weight<=permissibleWeight)
            return true;
        else
            return false;
    }

    public void move() {
        if (targetFloors.size() != 0 ) {
            if (waitingTime > 0) {
                waitingTime--;
            } else {
                isStaying = false;
                switch (direction) {
                    case down:
                        height++;
                        break;
                    case up:
                        height--;
                    case none:
                        isStaying = true;
                        break;
                }
            }
        } else {
             isStaying=true;
            direction=Direction.none;
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public List<Integer> getTargetFloors() {
        return targetFloors;
    }

    public void addTargetFloor(Integer number) {

        targetFloors.add(number);
        if (targetFloors.size()!=1) {
            Collections.sort(targetFloors);
            if (direction == Direction.down)
                Collections.reverse(targetFloors);
        }
        else {
            if (targetFloors.get(0)<currentFloor)
                direction=Direction.down;
                        else
                            direction=Direction.up;
        }
    }


    public void addPriorityTargetFloor(Integer number){
        targetFloors.add(number);
        Collections.sort(targetFloors);
        if (currentFloor<number){
            direction=Direction.up;
        }
        else{
            direction=Direction.down;
            Collections.reverse(targetFloors);
        }
    }
    public void removeTargetFloor(Integer number){
        while (targetFloors.contains(number))
        targetFloors.remove(number);
        if (targetFloors.size()!=0) {
            Collections.sort(targetFloors);
            if (direction == Direction.down)
                Collections.reverse(targetFloors);
        }
        else {
            direction =Direction.none;
        }
    }

    public List<Person> getPersons() {
        return persons;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public boolean isStaying() {
        return isStaying;
    }

    public void setStaying(boolean staying) {
        isStaying = staying;
    }

    public void setPersons(List<Person> persons) {

        this.persons = persons;
    }

    public List<Person> getPeronsCallers() {
        return peronsCallers;
    }

    public void setPeronsCallers(List<Person> peronsCallers) {
        this.peronsCallers = peronsCallers;
    }
}
