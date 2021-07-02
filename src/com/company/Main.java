package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static boolean[][] space = new boolean[32][32] ;
    public static Random random = new Random();

    public static String alive = "0";
    public static String dead = " ";




    public static void main(String[] args) {
        //randomize Field
        space = randomize(space);

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
