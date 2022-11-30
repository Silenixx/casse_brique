package models;

import java.awt.*;

public class Bonus extends Rond{
    protected int type;
    protected boolean toujours_dispo;




    public Bonus(int type, int positionX, int positionY, int diametre, boolean toujours_dispo) {
        this.type = type;
        this.positionX = positionX;

        this.positionY = positionY;

        this.diametre = diametre;

        if (this.type==1){
            this.couleur = new Color(
                    0,
                    255,
                    0);
        } else {
            this.couleur = new Color(
                    255,
                    0,
                    0);
        }


        this.toujours_dispo = toujours_dispo;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isToujours_dispo() {
        return toujours_dispo;
    }

    public void setToujours_dispo(boolean toujours_dispo) {
        this.toujours_dispo = toujours_dispo;
    }

   
}
