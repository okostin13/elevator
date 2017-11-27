import Configurators.*;
import Controllers.MainController;
import Core.*;
import Drawers.ConsoleDrawer;
import Drawers.StandartConsoleDrawer;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MainController mainController = new MainController();
        mainController.start();

    }
}