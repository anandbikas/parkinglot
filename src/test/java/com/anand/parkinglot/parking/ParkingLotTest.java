/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
package com.anand.parkinglot.parking;

import com.anand.parkinglot.exception.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class ParkingLotTest {

    public static String VALID_REGISTRATION_NUMBER = "KA-01-HH-1234" ;
    public static String VALID_REGISTRATION_NUMBER_1 = "KA-01-HH-5555" ;

    public static String INVALID_REGISTRATION_NUMBER = "KAAA-HH-1234" ;
    public static String WHITE_COLOR = "White";

    private ParkingLot parkingLot;
    private Vehicle vehicle;


    @BeforeClass
    private void setup(){
        parkingLot = new ParkingLot(6);
        vehicle = new Vehicle(VALID_REGISTRATION_NUMBER, WHITE_COLOR);
    }


    @Test()
    private void parkVehicle(){

        int existingVehicleCount = parkingLot.getVehicleCount();

        int allottedSlot = parkingLot.park(vehicle);

        Assert.assertEquals(parkingLot.getVehicleCount(), existingVehicleCount+1);
        Assert.assertEquals(parkingLot.getVehicle(allottedSlot), vehicle);
    }


    @Test(dependsOnMethods = "parkVehicle")
    private void getVehicleOfColour(){

        List<Integer> slots = parkingLot.getVehiclesOfColor(Colour.WHITE);

        Assert.assertEquals(slots.size(), 1);
        Assert.assertEquals(parkingLot.getVehicle(slots.get(0)), vehicle);
    }


    @Test(dependsOnMethods = "parkVehicle")
    private void getSlotNumberForRegistrationNumber(){

        int slot = parkingLot.getSlotNumberForRegistrationNumber(VALID_REGISTRATION_NUMBER);

        Assert.assertEquals(slot, 1);
        Assert.assertEquals(parkingLot.getVehicle(slot), vehicle);
    }


    @Test(dependsOnMethods = "parkVehicle", expectedExceptions = DuplicateVehicleException.class)
    private void parkDuplicateVehicle(){
        parkingLot.park(vehicle);

    }


    @Test(expectedExceptions = InvalidVehicleRegistrationException.class)
    private void parkInvalidRegistrationNumber(){
        parkingLot.park(new Vehicle(INVALID_REGISTRATION_NUMBER, WHITE_COLOR));

    }


    @Test(expectedExceptions = InvalidVehicleColorException.class)
    private void parkInvalidVehicleColour(){
        parkingLot.park(new Vehicle(VALID_REGISTRATION_NUMBER, "Indian"));

    }


    @Test(expectedExceptions = ParkingFullException.class)
    private void parkParkingFull(){
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(vehicle);
        parkingLot.park(new Vehicle(VALID_REGISTRATION_NUMBER_1, WHITE_COLOR));

    }

    @Test(expectedExceptions = VehicleNotFoundException.class)
    private void leaveVehicleNotFound(){

       parkingLot.leave(4);
    }


    @Test(expectedExceptions = ParkingSlotOutOfBoundException.class)
    private void leaveVehicleSlotNotFound(){

        parkingLot.leave(45);
    }


    @Test()
    private void leaveVehicle(){

        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.park(vehicle);

        int slotNumber =1;
        int existingVehicleCount = parkingLot.getVehicleCount();

        Vehicle leavingVehicle = parkingLot.leave(slotNumber);

        Assert.assertNull(parkingLot.getVehicle(slotNumber));

        Assert.assertEquals(parkingLot.getVehicleCount(), existingVehicleCount-1);
        Assert.assertEquals(leavingVehicle, vehicle);
    }

}

