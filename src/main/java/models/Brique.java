package models;

import java.awt.*;

public class Brique extends Rectangle{

    boolean isPasCasse;
    public Brique(int positionX, int positionY, int largeur, int hauteur, boolean isPasCasse) {
        this.positionX= positionX;
        this.positionY=positionY;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.isPasCasse = isPasCasse;

        this.couleur = new Color(
                (float)Math.random(),
                (float)Math.random(),
                (float)Math.random());
    }

    public boolean isPasCasse() {
        return isPasCasse;
    }

    public void setPasCasse(boolean pasCasse) {
        isPasCasse = pasCasse;
    }
}
