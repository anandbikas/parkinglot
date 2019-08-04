package com.anand.parkinglot;

import com.anand.parkinglot.command.Command;
import com.anand.parkinglot.parking.Colour;
import com.anand.parkinglot.parking.ParkingLot;
import com.anand.parkinglot.parking.Vehicle;

import java.util.List;
import java.util.StringJoiner;

/**
 * ParkingProcessor processes commands for parkingLot
 */
public class ParkingProcessor {

    private ParkingLot parkingLot;


    /**
     *
     */
    public ParkingProcessor() {
        super();
    }


    /**
     *
     * @param command
     */
    public void process(final Command command , final String []args){

        Colour vehicleColor;
        Integer allottedSlot;

        if(parkingLot == null && !command.equals(Command.CREATE_PARKING_LOT)) {
            System.out.println("Parking not created");
            return;
        }

        switch (command) {

            case CREATE_PARKING_LOT:
                if(parkingLot != null) {
                    System.out.println("Parking lot already created");
                    return;
                }
                if (args.length<2) {
                    System.out.println(String.format("Incomplete command: %s, slotCount required", command));
                    return;
                }

                int slotCount;
                try {
                    slotCount = Integer.parseInt(args[1]);
                } catch (NumberFormatException e){
                    System.out.println(String.format("Invalid slotCount: %s", args[1]));
                    return;
                }

                parkingLot = new ParkingLot(slotCount);
                System.out.println(String.format("Created a parking lot with %d slots", slotCount));
                break;

            case PARK:
                if (args.length<3) {
                    System.out.println(String.format("Incomplete command: %s, registration number and colour required", command));
                    return;
                }

                try {
                    allottedSlot = parkingLot.park(new Vehicle(args[1], args[2]));
                    System.out.println("Allocated slot number: " + allottedSlot);

                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;

            case LEAVE:
                if (args.length<2) {
                    System.out.println(String.format("Incomplete command: %s, slotNumber required", command));
                    return;
                }

                try {
                    allottedSlot = Integer.parseInt(args[1]);
                } catch (NumberFormatException e){
                    System.out.println(String.format("Invalid slotNumber: %s", args[1]));
                    return;
                }

                try {
                    parkingLot.leave(allottedSlot);
                    System.out.println(String.format("Slot number %s is free", allottedSlot));

                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;

            case STATUS:
                parkingLot.status();
                break;

            case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
                if (args.length<2) {
                    System.out.println(String.format("Incomplete command: %s, registrationNumber required", command));
                    return;
                }
                allottedSlot = parkingLot.getSlotNumberForRegistrationNumber(args[1]);
                if(allottedSlot==null){
                    System.out.println("Not found");
                    return;
                }
                System.out.println(allottedSlot);
                break;

            case SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
                if (args.length<2) {
                    System.out.println(String.format("Incomplete command: %s, colour required", command));
                    return;
                }

                vehicleColor = Colour.fromValue(args[1]);
                if(vehicleColor==null){
                    System.out.println(String.format("Vehicle color: %s, invalid", args[2]));
                    return;
                }

                List<Integer> colouredVehicleSlots = parkingLot.getVehiclesOfColor(vehicleColor);
                StringJoiner joiner = new StringJoiner(", ");

                if(colouredVehicleSlots != null){
                    colouredVehicleSlots.forEach(slot -> {
                        joiner.add(slot.toString());
                    });
                }
                System.out.println(joiner);
                break;

            case REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOR:
                if (args.length<2) {
                    System.out.println(String.format("Incomplete command: %s, colour required", command));
                    return;
                }

                vehicleColor = Colour.fromValue(args[1]);
                if(vehicleColor==null){
                    System.out.println(String.format("Vehicle color: %s, invalid", args[1]));
                    return;
                }

                colouredVehicleSlots = parkingLot.getVehiclesOfColor(vehicleColor);
                joiner = new StringJoiner(", ");

                if(colouredVehicleSlots != null){
                    for(Integer slot: colouredVehicleSlots){
                        Vehicle vehicle = parkingLot.getVehicle(slot);
                        if(vehicle != null){
                            joiner.add(vehicle.getRegistrationNumber());
                        }
                    }

                }
                System.out.println(joiner);
                break;

            default:
                //Default empty
                break;
        }
    }
}
