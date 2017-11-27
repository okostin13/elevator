package Drawers;

import Core.Shaft;

public class ShaftDrawer implements ConsoleDrawer {

    Shaft shaft;

    public ShaftDrawer(Shaft shaft) {
        this.shaft = shaft;
    }

    public void setShaft(Shaft shaft) {

        this.shaft = shaft;
    }

    public void draw(char[][] image) {
        for (int i=2;i<shaft.getHeight();i++){
            image[i][shaft.getLeftPadding()]='|';
            image[i][shaft.getLeftPadding()+4]='|';
        }
    }
}
