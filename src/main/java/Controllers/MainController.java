package Controllers;

import Core.Elevator;
import Drawers.Drawer;
import Drawers.StandartConsoleDrawer;

public class MainController implements Controller{

  private   ConfigurationController cfg;
  private ElevatorController elevatorController;
  private ButtonController btnController;
  private PersonController personController;
  private Drawer drawer;


    public void start() throws InterruptedException {
         cfg = new ConfigurationController();
        cfg.configAll();
        drawer = new StandartConsoleDrawer(cfg.getBuilding(),cfg.getPersons(),cfg.getElevators(),cfg.getFloors(),cfg.getShafts());
         elevatorController= new ElevatorController(cfg.getElevators(),cfg.getFloors());
         btnController = new ButtonController(cfg.getPersons(),cfg.getElevators());
         personController=new PersonController(cfg.getPersons(),cfg.getElevators(),btnController,cfg.getFloors());
         personController.call();
        while (!personController.isCompleted()){
            action();
        }

    }

    private void action() throws InterruptedException {

        personController.call();
        personController.action();
        elevatorController.action();

            drawer.draw();

    }

}
