/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
package com.anand.parkinglot;

import com.anand.parkinglot.command.Command;

import java.io.*;

/**
 * Parking Lot Main Class
 */
public class Main {

    private final static String SPACE_REGEX = "\\s+";
    private static BufferedReader br;

    private static final ParkingProcessor parkingProcessor = new ParkingProcessor();


    /**
     *
     * @param args
     */
    public static void main(String [] args){

        if(args.length>0){
            try {
                br = new BufferedReader(new FileReader(args[0]));
            } catch (FileNotFoundException e){
                System.out.println("File not found: " + args[0]);
                System.exit(1);
            }
        } else {
            System.out.println("Welcome to ParkingLot System");
            System.out.println("Supported commands:");
            System.out.println("-------------------");
            Command.display();
            System.out.println("-------------------");

            br = new BufferedReader(new InputStreamReader(System.in));
        }

        init();
    }

    /**
     *
     */
    private static void init(){

        String[] args;
        Command command=null;

        while(true) {
            try {
                String line = br.readLine();
                if(line == null || line.length()==0){
                    continue;
                }
                args = line.split(SPACE_REGEX);
            } catch (IOException e) {
                System.out.println("IOException! Try Again.");
                continue;
            }

            command = Command.fromValue(args[0]);
            if (command == null) {
                System.out.println(String.format("Command not supported: %s", args[0]));
                continue;
            }
            if(Command.EXIT.equals(command)){
                break;
            }

            parkingProcessor.process(command, args);
        }
    }
}
