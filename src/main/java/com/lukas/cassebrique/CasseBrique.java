package com.lukas.cassebrique;

import models.Balle;
import models.Barre;
import models.Bonus;
import models.Brique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class CasseBrique extends Canvas implements KeyListener {

    public static final int largeur = 800;
    public static final int hauteur = 600;

    public static boolean jeu_en_cours  = true;

    public static Barre barre = new Barre(300,560,200,20);

    Balle balle = new Balle(
            largeur/2,
            (hauteur/4)*3,
            20,
            4,
            -4);



    /*public static Brique brique1 = new Brique(10,10,400,20,true);
    public static Brique brique2 = new Brique(100,10,50,20,true);*/


    public CasseBrique() throws InterruptedException {
        JFrame fenetre = new JFrame("Casse brique");
        //On récupère le panneau de la fenetre principale
        JPanel panneau = (JPanel) fenetre.getContentPane();
        //On définie la hauteur / largeur de l'écran
        panneau.setPreferredSize(new Dimension(largeur, hauteur));
        setBounds(0, 0, largeur,hauteur);
        //On ajoute cette classe (qui hérite de Canvas) comme composant du panneau principal
        panneau.add(this);



        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.requestFocus();
        fenetre.addKeyListener(this);






        //On indique que le raffraichissement de l'ecran doit être fait manuellement.
        createBufferStrategy(2);
        setIgnoreRepaint(true);
        setFocusable(false);

        demarrer();
    }

    public void demarrer() throws InterruptedException {

        /*Balle[] tableauBalle = new Balle[1];

        for (int i = 0; i < tableauBalle.length; i ++){

            int largeurBalle = (int)(Math.random() * 40 + 10);
            int positionXdepart = (int)(Math.random() * (largeur - largeurBalle));
            int positionYdepart = (int)(Math.random() * (hauteur - 100)+100);

            int vitesseHorizontal = (int)(Math.random() * 8 -4);
            int vitesseVertical = (int)(Math.random() * 8 -4);

            tableauBalle[i] = new Balle(
                    positionXdepart,
                    positionYdepart,
                    largeurBalle,
                    vitesseHorizontal,
                    vitesseVertical);
        }*/

        Brique[] tableauBrique = new Brique[30];
        int colone=0;
        int ligne = 1;
        for (int j = 0; j < tableauBrique.length; j ++){
            if (colone==10){
                colone=1;
                ligne++;
            }else{
                colone++;
            }

            /*int positionXBrique = (int)(Math.random() * (largeur-200) + 10);
            int positionYBrique = (int)(Math.random() * (hauteur-200) + 10);*/
            int positionXBrique = (colone)*(largeur/12+5)-5;
            int positionYBrique = (ligne)*(hauteur/16+5)-5;

            int largeurBrique = largeur/12;
            int hauteurXBrique = hauteur/16;
            boolean ispascasseXBrique = true;




            tableauBrique[j] = new Brique(
                    positionXBrique,
                    positionYBrique,
                    largeurBrique,
                    hauteurXBrique,
                    ispascasseXBrique);
        }


        Bonus[] tableauBonus = new Bonus[8];
        int ligne_bonus=0;
        for (int j = 0; j < tableauBonus.length; j ++){
            ligne_bonus++;

            int type_bonus = (int) (Math.random() * (2) + 1);
            int positionXBonus = (ligne_bonus)*(hauteur/7);
            int positionYBonus = (hauteur/12)*8;

            int diametreBonus = 50;
            boolean ispasutiliseBonus = true;




            tableauBonus[j] = new Bonus(
                    type_bonus,
                    positionXBonus,
                    positionYBonus,
                    diametreBonus,
                    ispasutiliseBonus);
        }






        while(jeu_en_cours) {

            Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();

            dessin.setColor(Color.WHITE);
            dessin.fillRect(0,0, largeur, hauteur);



            balle.mouvement();
            balle.collision(largeur,hauteur,tableauBrique,tableauBonus);
            balle.dessiner(dessin);


            for(Bonus bonus : tableauBonus) {

                if(bonus.isToujours_dispo()){
                    bonus.dessiner(dessin);
                }
            }







            for(Brique brique : tableauBrique) {


                //brique.dessiner(dessin);
                if(brique.isPasCasse()){
                    brique.dessiner(dessin);
                }
            }

            if (barre.isToucheDroitePresse()){
                barre.deplacementDroite();
            }
            if (barre.isToucheGauchePresse()){
                barre.deplacementGauche();
            }

            barre.dessiner(dessin);






            //-----------------------------
            dessin.dispose();
            getBufferStrategy().show();
            Thread.sleep(1000 / 60);
        }
    }



    public static void main(String[] args) throws InterruptedException {
        new CasseBrique();
    }




    @Override
    public void keyTyped(KeyEvent e) {



    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()){
            case 37:
                barre.setToucheGauchePresse(true);
                break;
            case 39:
                barre.setToucheDroitePresse(true);
                break;

            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch(e.getKeyCode()){
            case 37:
                barre.setToucheGauchePresse(false);
                break;
            case 39:
                barre.setToucheDroitePresse(false);
                break;

            default:
                break;
        }


    }

    private void redemarrage() throws InterruptedException {
        jeu_en_cours=true;
        balle.setPositionX(largeur/2);
        balle.setPositionY((hauteur/4)*3);
        balle.setVitesseHorizontalBalle(4);
        balle.setVitesseVerticalBalle(-4);
        demarrer();


    }




}
