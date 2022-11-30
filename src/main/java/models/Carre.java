package models;

import java.awt.*;

public class Carre extends Sprite {

    protected int largeur;
    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillRect(positionX, positionY, largeur, largeur);
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
}