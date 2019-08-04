package com.anand.parkinglot.command;

import com.anand.io.ExtendedByteArrayOutputStream;
import com.anand.parkinglot.ParkingProcessor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;

@Test
public class ParkingProcessorTest {

    public static String VALID_REGISTRATION_NUMBER = "KA-01-HH-1234" ;
    public static String VALID_REGISTRATION_NUMBER_1 = "KA-01-HH-5555" ;

    public static String INVALID_REGISTRATION_NUMBER = "KAAA-HH-1234" ;
    public static String WHITE_COLOR = "White";
    public static String INVALID_COLOR = "Fair";


    private String [] outputs = {
            "Created a parking lot with 9 slots",
            "Parking lot already created",
            "Allocated slot number: 1",
            String.format("Vehicle registration number: %s, invalid", INVALID_REGISTRATION_NUMBER),
            String.format("Vehicle color: %s, invalid", INVALID_COLOR),
            "Slot number 1 is free",
            "Parking slot: 5 has no vehicle",
            "Parking not created"
    };

    private PrintStream systemOut = System.out;
    private ExtendedByteArrayOutputStream baos;

    private BufferedReader brOutput;

    private static final ParkingProcessor parkingProcessor = new ParkingProcessor();


    @BeforeMethod
    private void setUp() {
        baos = new ExtendedByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    private void setOutputBufferedReader(){
        brOutput = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(baos.getBuf())));
    }


    @Test()
    private void testParkParkingNotCreated() throws IOException {

        new ParkingProcessor().process(Command.PARK, new String[]{"", VALID_REGISTRATION_NUMBER, WHITE_COLOR});

        systemOut.println(baos.toString());

        setOutputBufferedReader();
        Assert.assertEquals(brOutput.readLine(), outputs[7]);
    }


    @Test()
    private void testCreateParkingLot() throws IOException{

        parkingProcessor.process(Command.CREATE_PARKING_LOT, new String[]{"", "9"});

        systemOut.println(baos.toString());

        setOutputBufferedReader();
        Assert.assertEquals(brOutput.readLine(), outputs[0]);
    }


    @Test(dependsOnMethods = "testCreateParkingLot")
    private void testCreateParkingLotAlreadyCreated() throws IOException{

        parkingProcessor.process(Command.CREATE_PARKING_LOT, new String[]{"", "9"});

        systemOut.println(baos.toString());

        setOutputBufferedReader();
        Assert.assertEquals(brOutput.readLine(), outputs[1]);
    }


    @Test(dependsOnMethods = "testCreateParkingLot")
    private void testPark() throws IOException{

        parkingProcessor.process(Command.PARK, new String[]{"", VALID_REGISTRATION_NUMBER, WHITE_COLOR});

        systemOut.println(baos.toString());

        setOutputBufferedReader();
        Assert.assertEquals(brOutput.readLine(), outputs[2]);
    }


    @Test(dependsOnMethods = "testCreateParkingLot")
    private void testParkInvalidRegistrationNumber() throws IOException{

        parkingProcessor.process(Command.PARK, new String[]{"", INVALID_REGISTRATION_NUMBER, WHITE_COLOR});

        systemOut.println(baos.toString());

        setOutputBufferedReader();
        Assert.assertEquals(brOutput.readLine(), outputs[3]);
    }


    @Test(dependsOnMethods = "testCreateParkingLot")
    private void testParkInvalidColor() throws IOException{

        parkingProcessor.process(Command.PARK, new String[]{"", VALID_REGISTRATION_NUMBER, INVALID_COLOR});

        systemOut.println(baos.toString());

        setOutputBufferedReader();
        Assert.assertEquals(brOutput.readLine(), outputs[4]);
    }


    @Test(dependsOnMethods = {"testCreateParkingLot", "testPark"})
    private void testRegistrationNumbersForCarsWithColour() throws IOException{
        parkingProcessor.process(Command.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOR, new String[]{"", WHITE_COLOR});

        systemOut.println(baos.toString());

        setOutputBufferedReader();
        Assert.assertEquals(brOutput.readLine(), VALID_REGISTRATION_NUMBER);
    }


    @Test(dependsOnMethods = {"testCreateParkingLot", "testPark"})
    private void testSlotNumbersForCarsWithColour() throws IOException{

        parkingProcessor.process(Command.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR, new String[]{"", WHITE_COLOR});

        systemOut.println(baos.toString());

        setOutputBufferedReader();
        Assert.assertEquals(brOutput.readLine(), "1");
    }


    @Test(dependsOnMethods = {"testCreateParkingLot", "testPark"})
    private void testSlotNumberForRegistrationNumber() throws IOException{

        parkingProcessor.process(Command.SLOT_NUMBER_FOR_REGISTRATION_NUMBER, new String[]{"", VALID_REGISTRATION_NUMBER});

        systemOut.println(baos.toString());

        setOutputBufferedReader();
        Assert.assertEquals(brOutput.readLine(), "1");
    }


    @Test(dependsOnMethods = {"testCreateParkingLot", "testPark"})
    private void testSlotNumberForRegistrationNumberNotFound() throws IOException{

        parkingProcessor.process(Command.SLOT_NUMBER_FOR_REGISTRATION_NUMBER, new String[]{"", VALID_REGISTRATION_NUMBER_1});

        systemOut.println(baos.toString());

        setOutputBufferedReader();
        Assert.assertEquals(brOutput.readLine(), "Not found");
    }


    @Test(dependsOnMethods = {"testCreateParkingLot", "testPark"})
    private void testStatus() throws IOException{


        parkingProcessor.process(Command.STATUS, new String[]{""});

        systemOut.println(baos.toString());

        String line1 = "Slot No.    Registration No    Colour";
        String line2 = "1           KA-01-HH-1234      White";

        setOutputBufferedReader();
        Assert.assertEquals(brOutput.readLine(), line1);
        Assert.assertEquals(brOutput.readLine(), line2);
    }


    @Test(dependsOnMethods = {"testCreateParkingLot"})
    private void testLeaveAlreadyFree() throws IOException{

        parkingProcessor.process(Command.LEAVE, new String[]{"", "5"});

        systemOut.println(baos.toString());

        setOutputBufferedReader();
        Assert.assertEquals(brOutput.readLine(), outputs[6]);
    }

    @Test()
    private void testLeave() throws IOException{

        final ParkingProcessor parkingProcessor = new ParkingProcessor();
        parkingProcessor.process(Command.CREATE_PARKING_LOT, new String[]{"", "9"});
        parkingProcessor.process(Command.PARK, new String[]{"", VALID_REGISTRATION_NUMBER, WHITE_COLOR});
        parkingProcessor.process(Command.LEAVE, new String[]{"", "1"});

        systemOut.println(baos.toString());

        setOutputBufferedReader();
        brOutput.readLine();
        brOutput.readLine();
        Assert.assertEquals(brOutput.readLine(), outputs[5]);
    }


    @AfterClass
    private void tearDown(){
        System.setOut(systemOut);
    }

}
