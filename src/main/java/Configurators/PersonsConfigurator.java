package Configurators;

import Core.Building;
import Core.Direction;
import Core.Person;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonsConfigurator implements Configurator  {

    public PersonsConfigurator(Building building) {
        this.building=building;
    }

    private Building building;
    private List<Person> persons ;
    private Scanner in = new Scanner(System.in);

    private void configPerson(Building building){
        Person person = new Person();
        configWeight(person);
        configCurrentFloor(person);
        configTargetFloor(person);
        if (person.getCurrentFloor()<person.getTargetFloor())
            person.setDirection(Direction.up);
        else
            person.setDirection(Direction.down);
        persons.add(person);
    }

    public List<Person> configure() {
        persons = new ArrayList<>();
        System.out.println("If you want to add a person print '1' else print '0'");
        int temp = in.nextInt();
        while (temp==1)
        {
            configPerson(building);
            System.out.println("If you want to add a person print '1' else print '0'");
            temp=in.nextInt();
        }
        return persons;
    }

    private void configCurrentFloor(Person person){
            System.out.println("Input person's current floor");
        int temp =in.nextInt();
        if (temp>0 && temp<=building.getFloorCount())
            person.setCurrentFloor(temp);
        else {
            System.out.println("Incorrect input");
            configCurrentFloor(person);
        }
    }
    private void configTargetFloor(Person person){
        System.out.println("Input person's target floor");
        int temp =in.nextInt();
        if (temp>0 && temp<=building.getFloorCount()&& temp!=person.getCurrentFloor())
            person.setTargetFloor(temp);
        else {
            System.out.println("Incorrect input");
            configTargetFloor(person);
        }
    }
    private void configWeight(Person person){
        System.out.println("Input person's weight");
        int temp =in.nextInt();
        if (temp>0)
            person.setWeight(temp);
        else {
            System.out.println("Incorrect input");
            configWeight(person);
        }
    }



}
