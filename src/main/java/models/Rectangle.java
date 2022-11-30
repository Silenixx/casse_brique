package models;

import java.awt.*;

public class Rectangle extends Carre{

    protected int hauteur;

    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillRect(positionX, positionY, largeur, hauteur);
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
}
