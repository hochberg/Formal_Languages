/**
 * file: driverDFA.java
 * author: Alex Hochberg
 * course: CMPT 440
 * assignment: lab 2
 * due date: February 15, 2016
 * version: 1.0
 *
 * This file contains the declaration of the ManWolf class.
 */

/*Imports*/
import java.lang.*;
import java.util.Scanner;

/**
 * driverDFA
 *
 * This class reads and handles user input and calls functions of ManWolf class.
 *
 */
public class driverDFA {


    /**
     * main
     *
     * This is the main function of the driverDFA class and fires
     * the programs functionality. It resets the program, reads user input,
     * calls Manwolf's process function, which prints results to screen.
     *
     */
    public static void main(String[] args) {
            //creates instance of manWolf for ManWolf class
            ManWolf manWolf = new ManWolf();
            //resets value of manWolf
            manWolf.reset();
            //creates instance of scanner, and reads input
            Scanner sc = new Scanner(System.in);
            //sets variable input to scanner's read value
            String input  = sc.next();
            //calls manWolf's process function to output solution results
            manWolf.process(input);

    }
}




