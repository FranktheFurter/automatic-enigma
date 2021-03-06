package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static int iInit = 16;
    public static int jInit = 16;
    public static int iterations = 30;

    public static boolean[][] space = new boolean[iInit][jInit];

    public static Random random = new Random();
    public static int randomthreshold =90;

    public static int interationcounter=1;
    public static String alive = " O ";
    public static String dead = "   ";
    public static String wall = " # ";




    public static void main(String[] args) throws InterruptedException {
        //randomize Field
        space = randomizer(space);

        //print field
        //printfield(space);    
        
        //game of life logic
        for (int i =0;i<iterations;i++){
        space = golLogic(space);
        printfield(space);
        
        Thread.sleep(200);
        }

        
    }
    private static  boolean[][] randomizer(boolean[][] field) {

        int upper = 100;
        int lower = 1;
        
    

        for (int i =0; i<field.length; i++){
            for (int j =0; j<field.length; j++){

                int rndmNumber =  (int) (Math.random() * (upper - lower)) + lower;
                //System.out.println(rndmNumber);


                if (randomthreshold <= rndmNumber){
                    field[i][j]=true;
            
                }
                else {
                    field[i][j]=false;
                }
            
            }
        }



        return field;
    }
    private static boolean[][] golLogic(boolean[][] field) {
        int aliveNeighboursCounter;
        boolean[][] tmpfield = field;
        //iterate trough all elements

        
        for (int i =0; i<iInit; i++){
            for (int j =0; j<jInit; j++){
                

                //count alive neighbours of cell in i,j
                aliveNeighboursCounter=countAliveNeighbours(field,i,j); 
               

                //cell logic

                if(field[i][j]==false && aliveNeighboursCounter==3){
                    tmpfield[i][j]=true;
                }
                else if(field[i][j]==true && aliveNeighboursCounter<2){
                    tmpfield[i][j]=false;
                }
                else if(field[i][j]==true && ((aliveNeighboursCounter==2)||(aliveNeighboursCounter==3))){
                    tmpfield[i][j]=true;
                }
                else if(field[i][j]==true && aliveNeighboursCounter>3){
                    tmpfield[i][j]=false;
                }
            }
        }
        

        return tmpfield;
    }

    private static int countAliveNeighbours(boolean[][] field, int i, int j) {
        int counter = 0;
        //all 8 cases

        //oben links
        counter+=safeAlive(field,i-1,j-1);
        //oben mitte
        counter+=safeAlive(field,i-1,j);
        //oben rechts
        counter+=safeAlive(field,i-1,j+1);
        //mitte links
        counter+=safeAlive(field,i,j-1);
        //mitte rechts
        counter+=safeAlive(field,i,j+1);
        //unten links
        counter+=safeAlive(field,i+1,j-1);
        //unten mitte
        counter+=safeAlive(field,i+1,j);
        //unten rechts
        counter+=safeAlive(field,i+1,j+1);

        return counter;
    }
    private static int safeAlive(boolean[][] field, int i, int j) {
        try {
            if(field[i][j]==true){
                return 1;
            }
        }
        catch(ArrayIndexOutOfBoundsException exception) {
            return 0;
        }

        return 0;
    }



    private static void printfield(boolean[][] field) {
       
        
        //debug
        //System.out.println("Alive neighbours at 0, 0      :" + countAliveNeighbours(field,0,0));
        for (int i = -1; i<iInit+1;i++){
            for (int j = -1; j<jInit+1;j++){
                
                try {


                 if(field[i][j]==true){

                System.out.print(alive);

                } else {

                    System.out.print(dead);
                }
            } catch(ArrayIndexOutOfBoundsException exception) {
                System.out.print(wall);;
            }
        }
            System.out.println();
        }

    System.out.println();    
    System.out.println("Iteration: "+interationcounter);
    System.out.println();
    interationcounter=interationcounter+1;
    

    }
}
