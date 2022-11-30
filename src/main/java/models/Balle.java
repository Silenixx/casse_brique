package models;

import com.lukas.cassebrique.CasseBrique;

import java.awt.*;
import java.util.Enumeration;

import static com.lukas.cassebrique.CasseBrique.barre;


public class Balle extends Rond{


    protected int vitesseHorizontalBalle = 5;

    protected int vitesseVerticalBalle = 5;



    public Balle(int positionX, int positionY, Color couleur, int largeur) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.couleur = couleur;
        this.diametre = largeur;
    }

    public Balle(int positionX, int positionY, int largeur,  int vitesseHorizontalBalle, int vitesseVerticalBalle) {
        this.positionX = positionX;
        this.vitesseHorizontalBalle = vitesseHorizontalBalle == 0 ? 1 : vitesseHorizontalBalle;
        this.positionY = positionY;
        this.vitesseVerticalBalle = vitesseVerticalBalle == 0 ? 1 : vitesseVerticalBalle;
        this.diametre = largeur;

        this.couleur = new Color(
                (float)Math.random(),
                (float)Math.random(),
                (float)Math.random());
    }

    public void mouvement() {
        positionX += vitesseHorizontalBalle;
        positionY += vitesseVerticalBalle;
    }

    public String type_mouvement() {
        String a = null;
        if(vitesseHorizontalBalle>0 && vitesseVerticalBalle>0)
        {
            a="BAS_DROITE";
        }
        else if(vitesseHorizontalBalle<0 && vitesseVerticalBalle<0)
        {
            a="HAUT_GAUCHE";
        }
        else if(vitesseHorizontalBalle>0 && vitesseVerticalBalle<0)
        {
            a="BAS_GAUCHE";
        }
        else if(vitesseHorizontalBalle<0 && vitesseVerticalBalle>0)
        {
            a="HAUT_DROITE";
        }

        return a;
    }

    public void collision(int largeurEcran, int hauteurEcran, Brique[] tableauBrique, Bonus[] tableauBonus){
        //si la balle est arrivée à droite ou à gauche alors on inverse sa vitesse
        if(positionX >= largeurEcran - diametre || positionX <= 0){
            vitesseHorizontalBalle *= -1;

        }

        /*if(positionY >= hauteurEcran - diametre || positionY <= 0  ){
            vitesseVerticalBalle *= -1;
        }*/

        if( positionY <= 0  ){
            vitesseVerticalBalle *= -1;
        }
        if (positionY >= hauteurEcran - diametre){
            CasseBrique.jeu_en_cours = false;
        }


        if(  ( barre.positionY <= positionY+diametre   ) && ( positionY+diametre <=  barre.positionY+ barre.largeur) &&
            ( barre.positionX <= positionX+diametre   ) && ( positionX+diametre <=  barre.positionX+ barre.largeur)
        ){
            vitesseVerticalBalle *= -1;
        }

        for(Bonus bonus : tableauBonus) {
            if ((positionY + diametre / 2 >= bonus.positionY) && (positionY + diametre / 2 <= bonus.positionY + bonus.diametre) &&
                    (positionX + diametre / 2 >= bonus.positionX) && (positionX + diametre / 2 <= bonus.positionX + bonus.diametre) &&
                    bonus.toujours_dispo
            ) {

                bonus.toujours_dispo = false;

                if(bonus.getType()==1) barre.setLargeur(barre.getLargeur()+40);
                if(bonus.getType()==2) barre.setLargeur(barre.getLargeur()-40);
            }
        }





        for(Brique brique : tableauBrique) {

            if(type_mouvement().equals("BAS_DROITE")){
                if(  ( positionY+diametre >= brique.positionY  ) && ( positionY+diametre <=  brique.positionY+ brique.hauteur) &&
                        ( positionX+diametre >= brique.positionX  ) && ( positionX+diametre <=  brique.positionX+ brique.largeur) &&
                        brique.isPasCasse
                ){
                    vitesseVerticalBalle *= -1;
                    brique.isPasCasse = false;
                }
            }
            else if(type_mouvement().equals("BAS_GAUCHE")){
                if(  ( positionY >= brique.positionY  ) && ( positionY <=  brique.positionY+ brique.hauteur) &&
                        ( positionX+diametre >= brique.positionX  ) && ( positionX+diametre <=  brique.positionX+ brique.largeur) &&
                        brique.isPasCasse
                ){
                    vitesseVerticalBalle *= -1;
                    brique.isPasCasse = false;
                }
            }
            else if(type_mouvement().equals("HAUT_DROITE")){
                if(  ( positionY+diametre >= brique.positionY  ) && ( positionY+diametre <=  brique.positionY+ brique.hauteur) &&
                        ( positionX >= brique.positionX  ) && ( positionX <=  brique.positionX+ brique.largeur) &&
                        brique.isPasCasse
                ){
                    vitesseVerticalBalle *= -1;
                    brique.isPasCasse = false;
                }
            }
            else if(type_mouvement().equals("HAUT_GAUCHE")){
                if(  ( positionY >= brique.positionY  ) && ( positionY <=  brique.positionY+ brique.hauteur) &&
                        ( positionX >= brique.positionX  ) && ( positionX <=  brique.positionX+ brique.largeur) &&
                        brique.isPasCasse
                ){
                    vitesseVerticalBalle *= -1;
                    brique.isPasCasse = false;
                }
            }










            /*if(  ( positionY >= brique.positionY  ) && ( positionY <=  brique.positionY+ brique.hauteur) &&
                    ( positionX+diametre >= brique.positionX  ) && ( positionX <=  brique.positionX+ brique.largeur) &&
                    brique.isPasCasse
            ){
                vitesseVerticalBalle *= -1;
                brique.isPasCasse = false;
            }*/
        }





    }





    public int getVitesseHorizontalBalle() {
        return vitesseHorizontalBalle;
    }

    public void setVitesseHorizontalBalle(int vitesseHorizontalBalle) {
        this.vitesseHorizontalBalle = vitesseHorizontalBalle;
    }



    public int getVitesseVerticalBalle() {
        return vitesseVerticalBalle;
    }

    public void setVitesseVerticalBalle(int vitesseVerticalBalle) {
        this.vitesseVerticalBalle = vitesseVerticalBalle;
    }



}
