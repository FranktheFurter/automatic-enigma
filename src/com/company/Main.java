package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static boolean[][] space = new boolean[32][32] ;
    public static Random random = new Random();

    public static int interationcounter=0;
    public static String alive = " O ";
    public static String dead = "   ";




    public static void main(String[] args) {
        //randomize Field
        space = randomize(space);

        //print field
        printfield(space);
        
        //game of life logic
        for (int i =0;i<10;i++){
        space = golLogic(space);
        printfield(space);
        }

    }
    private static boolean[][] golLogic(boolean[][] field) {
        int aliveNeighbours;
        //int deadNeighbours;
        //boolean cellValue;


        //debug
        //System.out.println(countAliveNeighbours(field, 0, 0));
        //System.out.println(countDeadNeighbours(field, 0, 0));

        
        //iterate trough all elements
        for (int i =0; i<field.length; i++){
            for (int j =0; j<field.length; j++){
                

                //count dead and alive of cell in i,j
                aliveNeighbours=countAliveNeighbours(field,i,j); 
                //deadNeighbours=countDeadNeighbours(field, i, j);

                //cell logic
                if(field[i][j]==false && aliveNeighbours==3){
                    field[i][j]=true;
                }
                if(field[i][j]==true && aliveNeighbours<2){
                    field[i][j]=false;
                }
                if(field[i][j]==true && ((aliveNeighbours==2)||(aliveNeighbours==3))){
                    field[i][j]=true;
                }
                if(field[i][j]==true && aliveNeighbours>3){
                    field[i][j]=false;
                }
            
            }
        }
        

        return field;
    }


    private static int countDeadNeighbours(boolean[][] field, int i, int j) {
        int counter = 0;
        //all 8 cases

        //oben links
        counter+=safeDead(field,i-1,j-1);
        //oben mitte
        counter+=safeDead(field,i-1,j);
        //oben rechts
        counter+=safeDead(field,i-1,j+1);
        //mitte links
        counter+=safeDead(field,i,j-1);
        //mitte rechts
        counter+=safeDead(field,i,j+1);
        //unten links
        counter+=safeDead(field,i+1,j-1);
        //unten mitte
        counter+=safeDead(field,i+1,j);
        //unten rechts
        counter+=safeDead(field,i+1,j+1);

        return counter;
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
    private static int safeDead(boolean[][] field, int i, int j) {
        try {
            if(field[i][j]==false){
                return 1;
            }
        }
        //out of bounds is dead
        catch(ArrayIndexOutOfBoundsException exception) {
            return 1;
        }

        return 0;
    }





    private static void printfield(boolean[][] field) {
        /*
        System.out.println(Arrays.deepToString(space).replace("], ", "]\n").replace("[[", "[").replace("]]", "]").replace("true", alive).replace("false", dead));
        System.out.println();
        */

        for (int i = 0; i<field.length;i++){
            for (int j = 0; j<field.length;j++){
                

                if(field[i][j]==true){

                System.out.print(alive);

                } else {

                    System.out.print(dead);
                }
            }
            System.out.println();
        }

        
    System.out.println("-------------------Iteration: "+interationcounter+"----------------------");
    interationcounter=interationcounter+1;

    }
    public static boolean[][] randomize (boolean[][] space){

        for (int i = 0; i<space.length;i++){
            for (int j = 0; j<space.length;j++){
                space[i][j] = random.nextBoolean();;

            }
        }

        return space;
    }
}
