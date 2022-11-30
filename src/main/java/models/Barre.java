package models;

import com.lukas.cassebrique.CasseBrique;

import java.awt.*;

public class Barre extends Rectangle{

    boolean ToucheDroitePresse;
    boolean ToucheGauchePresse;



    public Barre(int positionX, int positionY, int largeur, int hauteur) {
        this.positionX= positionX;
        this.positionY=positionY;
        this.largeur = largeur;
        this.hauteur = hauteur;

        this.couleur = new Color(
                (float)Math.random(),
                (float)Math.random(),
                (float)Math.random());

        this.ToucheDroitePresse = false;
        this.ToucheGauchePresse = false;

    }

    public void  deplacementDroite(){
        if(positionX < CasseBrique.largeur-largeur){
            positionX+=5;
        }

    }
    public void deplacementGauche(){
        if(positionX> 0){
            positionX-=5;
        }

    }


    public boolean isToucheDroitePresse() {
        return ToucheDroitePresse;
    }

    public void setToucheDroitePresse(boolean toucheDroitePresse) {
        ToucheDroitePresse = toucheDroitePresse;
    }

    public boolean isToucheGauchePresse() {
        return ToucheGauchePresse;
    }

    public void setToucheGauchePresse(boolean toucheGauchePresse) {
        ToucheGauchePresse = toucheGauchePresse;
    }
}
