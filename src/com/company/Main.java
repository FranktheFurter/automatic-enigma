package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static boolean[][] space = new boolean[32][32] ;
    public static Random random = new Random();

    public static String alive = "1";
    public static String dead = "0";




    public static void main(String[] args) {
        //randomize Field
        space = randomize(space);

        //print field
        printfield(space);
        
        //game of life logic
        space = golLogic(space);

    }
    private static boolean[][] golLogic(boolean[][] field) {
        int aliveNeighbours;
        int deadNeighbours;
        boolean cellValue;

        //iterate trough all elements
        for (int i =0; i<field.length; i++){
            for (int j =0; j<field.length; j++){
                cellValue = field[i][j];

                aliveNeighbours=countAliveNeighbours(field,i,j); 
                deadNeighbours=countDeadNeighbours(field,i,j);
            
            }
        }


        return field;
    }


    @todo // implement
///////////////
private static int countDeadNeighbours(boolean[][] field, int i, int j) {
        return 0;
    }
    private static int countAliveNeighbours(boolean[][] field, int i, int j) {
        return 0;
    }
///////////////





    private static void printfield(boolean[][] field) {
        System.out.println(Arrays.deepToString(space).replace("], ", "]\n").replace("[[", "[").replace("]]", "]").replace("true", alive).replace("false", dead));
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
