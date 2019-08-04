/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
package com.anand.parkinglot;

import com.anand.io.ExtendedByteArrayOutputStream;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;

@Test
public class MainTest {

    private static final String INPUT_FILE_PATH = "src/test/resources/input.txt";
    private static final String OUTPUT_FILE_PATH = "src/test/resources/output.txt";

    private PrintStream systemOut = System.out;
    private ExtendedByteArrayOutputStream baos;

    private BufferedReader brFile;
    private BufferedReader brOutput;

    @BeforeMethod
    private void setUp() throws FileNotFoundException {

        baos = new ExtendedByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        brFile = new BufferedReader(new FileReader(OUTPUT_FILE_PATH));
    }

    private void setOutputBufferedReader(){
        brOutput = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(baos.getBuf())));
    }

    /**
     * Test ParkingLot Main class and compare the output against input.txt file.s
     */
    @Test
    private void parkingLot(){

        String [] args = {INPUT_FILE_PATH};

        Main.main(args);

        systemOut.println(baos.toString());

        setOutputBufferedReader();

        brFile.lines().forEach(line1 -> {
            String line2;
            try {
                line2 = brOutput.readLine();
            } catch (IOException e){
                throw new RuntimeException("IOException");
            }
            Assert.assertNotNull(line2);
            Assert.assertEquals(line2, line1);
        });

    }

    @AfterMethod
    private void tearDown(){
        System.setOut(systemOut);
    }
}
