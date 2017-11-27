package Core;

import java.util.List;

public class Floor {
    private int height;
    private int number;
    private int width;
    private List<Person> persons;
    private List<Elevator> elevators;
    private int personsCount=0;
    private int completedPersonsCount=0;

    public int getCompletedPersonsCount() {
        return completedPersonsCount;
    }

    public void setCompletedPersonsCount(int completedPersonsCount) {
        this.completedPersonsCount = completedPersonsCount;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public List<Elevator> getElevators() {
        return elevators;
    }

    public void setElevators(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getPersonsCount() {
        return personsCount;
    }

    public void setPersonsCount(int personsCount) {
        this.personsCount = personsCount;
    }

}
