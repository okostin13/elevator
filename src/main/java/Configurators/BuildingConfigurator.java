package Configurators;

import Core.Building;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuildingConfigurator implements Configurator {

   private Building building;

   private Scanner in = new Scanner(System.in);
    private void configFloors(){
        System.out.println("Input number of floors");
        int count = in.nextInt();
        if ((building.getHeight()-7)/3>=count)
            building.setFloorCount(count);
        else {
            System.out.println("Too many floors");
            configFloors();
        }
    }

    private void configShafts(){
        System.out.println("Input number of elevators");
        int count = in.nextInt();
        if ((building.getWidth()-4)/8>=count) {
            building.setShaftCount(count);
            building.setElevatorCount(count);
        }
        else {
            System.out.println("Too many elevators");
            configShafts();
        }
    }

    public List<Building> configure(){
        building=new Building();
        System.out.println("Input building's width(recommended from 30 to 120)");
        int temp = in.nextInt();
        building.setWidth( temp);
        System.out.println("Input building's height(recommended from 20 to 40)");
        temp = in.nextInt();
        building.setHeight(temp);
        configFloors();
        configShafts();
        return new ArrayList<Building>(){
            {
                add(building);
            }
        };
    }
}
