// Hung Le
// C00181055
// CMPS 360
// Programming Project : #8
// Problem Number: #2
// Due Date : 4/30/2018 4:30 PM
// Program Description: Shows a table that converts km to miles based on user input of beginning and ending values.
// Certificate of Authenticity: I certify that the code of this project are entirely my own work.
package p8_2_c00181055;

import java.util.*;

/**
 * main class for program that shows a table that converts km to miles based on user input of beginning and ending values.
 * @author hql0510
 */
public class P8_2_c00181055 {

    /**
     * A user inputs a starting integer km and ending integer km
     * and the program calculates 10 values in between and
     * converts the km to miles.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Integer start, end;

        //Get input
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the starting kilometers: ");
        start = reader.nextInt();
        System.out.println("Enter the ending kilometers: ");
        end = reader.nextInt();
        reader.close();

        //Convert
        //1km = 0.621371
        //Make table
        List<Double> table = new ArrayList<Double>();
        for (int i = 0; i < 10; i++) {
            table.add(i, ((end.doubleValue() - start.doubleValue()) / 10) * (i + 1));
        }

        System.out.println();
        System.out.printf("%-15s %15s %n", "Kilometers", "Miles");
        System.out.println("-------------------------------");
        System.out.printf("%-15.2f", start.doubleValue());
        System.out.printf("%15.2f %n", start.doubleValue() * 0.621371);

        for (Double row : table) {
            System.out.println("-------------------------------");
            System.out.printf("%-15.2f", row);
            System.out.printf("%15.2f", row * 0.621371);
            System.out.println();
        }
        
        System.out.println("-------------------------------");
        System.out.printf("%-15.2f", end.doubleValue());
        System.out.printf("%15.2f %n", end.doubleValue() * 0.621371);
    }

}
