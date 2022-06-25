package main;

import acm.program.ConsoleProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * File: ModeCalculator.java
 * --------------------------
 * calculates the mode of the
 */
public class ModeCalculator extends ConsoleProgram {

    /**
     * the main entry method for the program
     *
     * @param args the passed command line argument
     */
    public static void main(String[] args) {

        //initialization of the class
        new ModeCalculator().start(args);
    }

    /**
     * the main run method for the application
     */
    public void run() {

        println("finding the modes inside an array list of doubles");
        println("the array is: ");
        double [] array={1.0,2.0,2.0,3.0,3.0,3.0,4.0,4.0,5.0,6.0,6.0,6.0,7.0,8.0,9.0};
        for (Double v:array){
            print(v+", ");
        }

        println("\nthe modes are: ");
        List<Double> modes= modeCalculator(array);
        for (Double d: modes){
            print(d+", ");
        }

    }

    /**
     * calculates the mode[s] of an array
     */
    public List<Double> modeCalculator(double[] array) {

        //setting up the needed variables
        HashMap<Double, Integer> dataMap = new HashMap<>();
        List<Double> modes = new ArrayList<>();
        int max = 0;
        int counter=0;

        //going through the array
        for (double v : array) {

            if (dataMap.containsKey(v)) {
                counter = dataMap.get(v) + 1;
                dataMap.replace(v, counter);
            } else {
                counter = 1;
                dataMap.put(v, counter);
            }

            //getting the max values
            if (counter>max){
                max=counter;
            }
        }

        //getting the modes
        for (Double key : dataMap.keySet()) {
            if (dataMap.get(key)==max){
                modes.add(key);
            }
        }

        //returning the modes
        return modes;

    }
}
