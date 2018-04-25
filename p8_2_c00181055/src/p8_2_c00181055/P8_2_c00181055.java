/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p8_2_c00181055;

import java.util.*;

/**
 *
 * @author hql0510
 */
public class P8_2_c00181055 {

    /**
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
    }

}
