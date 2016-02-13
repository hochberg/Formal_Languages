/**
 * file: ManWolf.java
 * author: Alex Hochberg
 * course: CMPT 440
 * assignment: lab 2
 * due date: February 15, 2016
 * version: 1.0
 *
 * This file contains the declaration of the ManWolf class.
 */


/**
 * ManWolf
 *
 * This class implements a DFA for for the man-wolf-goat-cabbage problem,
 * and supports resetting and processing if different solutions work or do not work.
 *
 */
public class ManWolf {

    /* Constants */

    //State Declarations
    private static final int q0 = 0;
    private static final int q1 = 1;
    private static final int q2 = 2;
    private static final int q3 = 3;
    private static final int q4 = 4;
    private static final int q5 = 5;
    private static final int q6 = 6;
    private static final int q7 = 7;
    private static final int q8 = 8;
    private static final int q9 = 9;
    private static final int qE = 10;

    //Transtition States Declarations - delta
    static private int[][] delta = {
            //w  g  c  n
            {qE,q1,qE,qE},//q0
            {qE,q0,qE,q2},//q1
            {q3,qE,q5,q1},//q2
            {q2,q4,qE,qE},//q3
            {qE,q3,q7,qE},//q4
            {qE,q6,q2,qE},//q5
            {q7,q5,qE,qE},//q6
            {q6,qE,q4,q8},//q7
            {qE,q9,qE,q7},//q8
            {qE,q8,qE,qE},//q9
            {qE,qE,qE,qE} //qE
    };

    /* Varaiable Initializations */

    //inital state
    int state = q0;
    //initialize invalid character
    boolean invalid = false;

   /* Functions */

    /**
     * reset
     *
     * This function resets the initial values for process the man-wolf-cabbage solution,
     * The values of variables, state and invalid, are reset to their inital values.
     *
     */
    public void reset() {
        //sets state and invalid to inital values
        state = q0;
        invalid = false;

    };

    /**
     * process
     *
     * This function processes the user's input string solution, compares each step to the
     * solution matrix step by step, determines if a working solution, a non-working solution
     * or invalid input was given, and then prints the results to the screen.
     *
     * Parameters:
     *   in: the string that is input by the user, their given solution
     *
     */
    public void process(String in){
        //loops through length of input string, char by char
        for(int i = 0; i < in.length();i++){

            //initalizes local variable, move
            int move;

            //finds current char, sets to lowercase
            char c = Character.toLowerCase(in.charAt(i));

            //compares current char to valid steps, w,g,c,and n
            //and sets move to proper location in transition matrix
            switch(c)
            {
                case 'w' :
                    move = 0;
                    break;
                case 'g' :
                    move = 1;
                    break;
                case 'c' :
                    move = 2;
                    break;
                case 'n' :
                    move = 3;
                    break;

                //if char other than w,g,c,n is given
                //sets invalid to notify user of bad input
                default :
                    move = 0;
                    state = qE;
                    invalid = true;

            }
            //changes state depending on current state and next move that was just calculated
            state = delta[state][move];
        }
        //in case of invalid character, prints invalid message
        if(invalid){
            System.out.println("An invalid character was entered.");
        //if success state is reached , q9, print success message
        }else if (state == q9){
            System.out.println("That is a solution.");
        //else, print unsuccessful message
        }else{
            System.out.println("That is not a solution.");
        }
    }


}
