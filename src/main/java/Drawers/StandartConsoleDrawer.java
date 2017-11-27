package Drawers;

import Core.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StandartConsoleDrawer implements Drawer {
    int height ;
    int width;
    String stringImage;
    char[][] image ;
    BuildingDrawer buildingDrawer ;
    List <ShaftDrawer> shaftDrawers;
    List<FloorDrawer> floorDrawers;
    List<ElevatorDrawer> elevatorDrawers;
    LogDrawer logDrawer;
    List<ConsoleDrawer> consoleDrawers;

    public StandartConsoleDrawer(Building building, List<Person> persons, List<Elevator> elevators, List<Floor> floors, List<Shaft> shafts){
        height =building.getHeight()+ 15;
        width = building.getWidth()+9;
        image =new char[height][width];
        consoleDrawers = new ArrayList<>();
        buildingDrawer = new BuildingDrawer(building);
        consoleDrawers.add(buildingDrawer);

        for (Floor floor:floors){
            floorDrawers=new ArrayList<>();
            floorDrawers.add(new FloorDrawer(floor));
            consoleDrawers.add(new FloorDrawer(floor));
        }
        for (Shaft shaft:shafts){
            shaftDrawers=new ArrayList<>();
            shaftDrawers.add(new ShaftDrawer(shaft));
            consoleDrawers.add(new ShaftDrawer(shaft));
        }

        for (Elevator elevator:elevators){
            elevatorDrawers = new ArrayList<>();
            elevatorDrawers.add(new ElevatorDrawer(elevator));
            consoleDrawers.add(new ElevatorDrawer(elevator));
        }


    }


    public void fillImage(char[][] image){
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                image[i][j]=' ';
            }
        }
    }
    private String parse(){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                sb.append(image[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void draw() throws InterruptedException {
        System.out.print("\033[H\033[2J");
    //    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
     /*   buildingDrawer.draw();
        for (FloorDrawer fd : floorDrawers) {
            fd.draw();
        }
        for (ElevatorDrawer ed : elevatorDrawers) {

            ed.draw();
        }
        logDrawer.draw(); */

     fillImage(image);

     for(ConsoleDrawer cd :consoleDrawers ){
         cd.draw(image);
     }

     System.out.print(parse());
        Thread.sleep(100);
    }

}



